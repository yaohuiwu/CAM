package org.cam.core.cache.user;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import org.cam.core.cache.CacheDataAccessor;
import org.cam.core.cache.InnerCache;
import org.cam.core.domain.User;

import java.io.Serializable;

public class CurrentUserCache {

    private CacheDataAccessor<Serializable,User> cacheDataAccessor ;

    public CurrentUserCache() {
        CacheManager cacheManager = CacheManager.getInstance();
        Ehcache currentUserCache = cacheManager.getEhcache(InnerCache.cam_current_user.toString());
        cacheDataAccessor = new CacheDataAccessor<>(currentUserCache);
    }

    public User getUser(Serializable key){
        return cacheDataAccessor.get(key);
    }

    public void putUser(Serializable key , User user){
        cacheDataAccessor.put(key,user);
    }

}
