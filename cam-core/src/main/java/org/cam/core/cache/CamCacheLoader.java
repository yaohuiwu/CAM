package org.cam.core.cache;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Status;
import net.sf.ehcache.loader.CacheLoader;
import org.cam.core.CamException;
import org.cam.core.annotation.ExecutableType;
import org.cam.core.dao.PersistentDao;
import org.cam.core.domain.Authorization;
import org.cam.core.domain.Permission;
import org.cam.core.domain.PermissionSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CamCacheLoader implements CacheLoader{

    private static final Logger LOG = LoggerFactory.getLogger(CamCacheLoader.class);

    private PersistentDao persistentDao;

    public CamCacheLoader(PersistentDao persistentDao) {
        this.persistentDao = persistentDao;
    }

    @Override
    public Object load(Object key) throws CacheException {
        LOG.debug("load {}",key);

        Permission p = new Permission(ExecutableType.CREATE.toString(),"User","org_id=1");
        p.setId("perm_001");
        return p;
    }

    @Override
    public Map loadAll(Collection keys) {
        return null;
    }

    @Override
    public Object load(Object key, Object argument) {
        if(!(argument instanceof InnerCache)){
            throw new CamException("Argument of getWithLoader must be instance of org.cam.cache.InnerCache");
        }
        Object loadedObject;
        InnerCache cacheType = (InnerCache)argument;
        switch (cacheType){
            case authorization:
                //key is role id , value is PermissionSet
                PermissionSet permSet = persistentDao.getPermissionOfRole((String)key);
                loadedObject = permSet;
                if(LOG.isTraceEnabled()){
                    LOG.trace("{} loaded from sor into '{}' cache",permSet,InnerCache.authorization.toString());
                }
                break;
            case permission:
                //key is permission id
                loadedObject = persistentDao.getSinglePermission((String)key);
                if(LOG.isTraceEnabled()){
                    LOG.trace("{} loaded from sor into '{}' cache",loadedObject,InnerCache.permission.toString());
                }
                break;
            default:
                throw new CamException("No loader method for cache "+cacheType);
        }
        return loadedObject;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map loadAll(Collection keys, Object argument) {
        if(!(argument instanceof InnerCache)){
            throw new CamException("Argument of getWithLoader must be instance of org.cam.cache.InnerCache");
        }
        Map loadedMap = Maps.newHashMap() ;
        InnerCache cacheType = (InnerCache)argument;
        switch (cacheType){
            case authorization:
                //key is role id , value is PermissionSet
                Set<String> roleSet = Sets.newHashSet();
                roleSet.addAll(keys);
                Map<String,Set<Authorization>> authMap = persistentDao.getAuthorizationByRoles(roleSet);
                for(Map.Entry<String,Set<Authorization>> entry : authMap.entrySet()){
                    Set<String> permIdSet = Sets.newHashSet();
                    for(Authorization au : entry.getValue()){
                        permIdSet.add(au.getPermissionId());
                    }
                    loadedMap.put(entry.getKey(),new PermissionSet(permIdSet));
                }
                if(LOG.isTraceEnabled()){
                    LOG.trace("{} loaded from sor into '{}' cache",loadedMap,InnerCache.authorization.toString());
                }
                break;
            case permission:
            default:
                throw new CamException("No loader method for cache "+cacheType);
        }
        return loadedMap;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public CacheLoader clone(Ehcache cache) throws CloneNotSupportedException {
        return null;
    }

    @Override
    public void init() {

    }

    @Override
    public void dispose() throws CacheException {

    }

    @Override
    public Status getStatus() {
        return null;
    }
}
