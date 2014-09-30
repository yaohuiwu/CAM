package org.cam.core.dao;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.cam.core.cache.Caches;
import org.cam.core.cache.InnerCache;
import org.cam.core.domain.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A {@link org.cam.core.dao.CamDao} implementation using ehcache as cache layer and RDBMS as SOR.
 *
 */
public class CamDaoImpl implements CamDao{

    private CacheManager cacheMgr;
    private Ehcache usrRoleCache;
    private Ehcache authCache;
    private Ehcache permCache;


    private PersistentDao persistentDao;

    public CamDaoImpl() {
        this(null);
    }

    public CamDaoImpl(PersistentDao persistentDao) {
        this.persistentDao = persistentDao;
        cacheMgr = cacheMgr.getInstance();

        usrRoleCache = cacheMgr.getCache(InnerCache.user_role.toString());
        authCache = cacheMgr.getCache(InnerCache.authorization.toString());
        permCache = cacheMgr.getCache(InnerCache.permission.toString());
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
        Element ele = Caches.getWithDefaultLoader(roleId,null, authCache);
        PermissionSet permSet = Caches.extractValue(ele,PermissionSet.class);
        return PermissionSet.safeGet(permSet);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Set<String>> getPermissionsIdOfRoles(Set<String> roleSet) {
        Map<String,Set<String>> mp = Maps.newHashMap();
        Map rolePermMap = authCache.getAllWithLoader(roleSet,null);
        Iterator<Map.Entry<String,PermissionSet>> iterator = rolePermMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,PermissionSet> entry = iterator.next();
            mp.put(entry.getKey(), PermissionSet.safeGet(entry.getValue()));
        }
        return mp;
    }

    @Override
    public Permission getSinglePermission(String permissionId) {
        Element element = Caches.getWithDefaultLoader(permissionId,permCache);
        return Caches.extractValue(element,Permission.class);
    }

    @Override
    public List<Permission> getPermissionsOfRoles(Set<String> roleIdSet, String action, String objectType) {
        List<Permission> permList = Lists.newArrayList();
        Map<String, Set<String>> rolePermMap = getPermissionsIdOfRoles(roleIdSet);
        Iterator<Set<String>>  iterator = rolePermMap.values().iterator();
        while(iterator.hasNext()){
            Set<String> permSet = iterator.next();
            Iterator<String> permIt = permSet.iterator();
            while(permIt.hasNext()){
                Element element = Caches.getWithDefaultLoader(permIt.next(),null,permCache);
                Permission perm = Caches.extractValue(element,Permission.class);
                if(perm!=null){
                    if(action.equals(perm.getAction()) && objectType.equals(perm.getObjectType())){
                        permList.add(perm);
                    }
                }
            }
        }
        return permList;
    }
}
