package org.cam.core.dao;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.cam.core.CamException;
import org.cam.core.FactoryHelper;
import org.cam.core.cache.Caches;
import org.cam.core.cache.InnerCache;
import org.cam.core.domain.Permission;
import org.cam.core.domain.PermissionSet;
import org.cam.core.domain.Role;
import org.cam.core.domain.RoleSet;
import org.cam.core.domain.StringSet;
import org.cam.core.domain.User;
import org.cam.core.parser.ParserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A {@link org.cam.core.dao.CamDao} implementation using ehcache as cache layer and RDBMS as SOR.
 *
 */
public class CamDaoImpl implements CamDao{

    private static final Logger LOG = LoggerFactory.getLogger(CamDaoImpl.class);

    private CacheManager cacheMgr;
    private Ehcache usrRoleCache;
    private Ehcache authCache;
    private Ehcache permCache;
    private Ehcache queryListCache;
    private boolean queryCacheEnabled;


    private PersistentDao persistentDao;

    public CamDaoImpl() {
        this(null);
    }

    public CamDaoImpl(PersistentDao persistentDao) {
        this.persistentDao = persistentDao;
        cacheMgr = Caches.getCacheManager();

        usrRoleCache = cacheMgr.getCache(InnerCache.user_role.toString());
        authCache = cacheMgr.getCache(InnerCache.authorization.toString());
        permCache = cacheMgr.getCache(InnerCache.permission.toString());

        queryCacheEnabled = FactoryHelper.configuration().isEnableQueryListCache();
        if(queryCacheEnabled){
            queryListCache = Caches.createMemCache(InnerCache.cam_query_list.toString(),
                    1000, // max entries in local heap.
                    3600, //time to live.
                    3600 //time to idle.
                    );
            cacheMgr.addCache(queryListCache);
        }
    }

    @Override
    public Set<String> getCachedRolesOfUser(User user) {
        RoleSet roleSet = Caches.get(user.getId(), RoleSet.class, usrRoleCache);
        return RoleSet.safeGet(roleSet);
    }

    @Override
    public Set<Role> getAllRoleFromSor() {
        List<Role> roles = persistentDao.getAllRole();
        Set<Role> roleSet = Sets.newHashSet();
        roleSet.addAll(roles);
        return roleSet;
    }

    @Override
    public void cacheRolesOfUser(User user, Set<String> roles) {
        RoleSet roleSet = new RoleSet(roles);
        usrRoleCache.put(Caches.element(user.getId(), roleSet));
    }

    @Override
    public Set<String> getPermissionIdsOfRole(String roleId) {
        Element ele = Caches.getWithDefaultLoader(roleId,InnerCache.authorization, authCache);
        PermissionSet permSet = Caches.extractValue(ele,PermissionSet.class);
        return PermissionSet.safeGet(permSet);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Set<String>> getPermissionsIdOfRoles(Set<String> roleSet) {
        Map<String,Set<String>> mp = Maps.newHashMap();
        Map rolePermMap = authCache.getAllWithLoader(roleSet,InnerCache.authorization);
        Iterator<Map.Entry<String,PermissionSet>> iterator = rolePermMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,PermissionSet> entry = iterator.next();
            PermissionSet permSet = entry.getValue();
            //ignore empty value.
            if(permSet!=null){
                mp.put(entry.getKey(), PermissionSet.safeGet(entry.getValue()));
            }
        }
        return mp;
    }

    @Override
    public Permission getSinglePermission(String permissionId) {
        Element element = Caches.getWithDefaultLoader(permissionId,InnerCache.permission,permCache);
        return Caches.extractValue(element,Permission.class);
    }

    @Override
    public List<Permission> getPermissionsOfRoles(Set<String> roleIdSet, String action, String objectType) {

        if(ParserUtil.isAll(action) || ParserUtil.isAll(objectType)){
            throw new CamException("action and objectType must be specified explicitly.");
        }
        List<Permission> permList = Lists.newArrayList();
        Map<String, Set<String>> rolePermMap = getPermissionsIdOfRoles(roleIdSet);
        Iterator<Set<String>>  iterator = rolePermMap.values().iterator();
        while(iterator.hasNext()){
            Set<String> permSet = iterator.next();
            Iterator<String> permIt = permSet.iterator();
            while(permIt.hasNext()){
                Element element = Caches.getWithDefaultLoader(permIt.next(),InnerCache.permission,permCache);
                Permission perm = Caches.extractValue(element,Permission.class);
                if(ParserUtil.typeMatch(action,objectType,perm)){
                    permList.add(perm);
                }
            }
        }
        return permList;
    }

    @Override
    public Collection<String> singleColumnListQuery(String queryString) {
        if(queryCacheEnabled){
            final boolean debugEnabled = LOG.isDebugEnabled();
            Element ele = queryListCache.get(queryString);
            if(ele!=null){
                StringSet listValues = Caches.extractValue(ele,StringSet.class);
                if(debugEnabled){
                    LOG.debug("query list cache hit for query:{}",queryString);
                }
                return listValues.getIdSet();
            }
            if(debugEnabled){
                LOG.debug("query list cache miss hit for query:{}",queryString);
            }
        }
        Set<String> valuesFromDb = persistentDao.singleColumnListQuery(queryString,1);
        if(queryCacheEnabled){
            queryListCache.put(Caches.element(queryString,new StringSet(valuesFromDb)));
        }
        return valuesFromDb;
    }
}
