package org.cam.core.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.CopyStrategyConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration;
import org.cam.core.CamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wuyaohui on 14-9-28.
 */
public class CacheUtils {

    private static final Logger LOG = LoggerFactory.getLogger(CacheUtils.class);

    private static final CacheManager cacheMgr = CacheManager.create();

    public static Cache createCopyOnReadMemoryOnlyCache(String cacheName,int maxElementsInMemory){
        return createMemoryOnlyCache(cacheName, maxElementsInMemory, true);
    }

    public static Cache createMemoryOnlyCache(String cacheName, int maxElementsInMemory, boolean copyOnRead){
        if(cacheMgr.cacheExists(cacheName)){
            LOG.warn("Cache with name "+cacheName+" already exists.");
            return cacheMgr.getCache(cacheName);
        }
        CacheConfiguration cfg = new CacheConfiguration(cacheName,maxElementsInMemory);
        cfg.setName(cacheName);

        PersistenceConfiguration persistentCfg = new PersistenceConfiguration();
        persistentCfg.strategy(PersistenceConfiguration.Strategy.NONE);

        cfg.persistence(persistentCfg)
                .eternal(true)
                .copyOnRead(copyOnRead)
        ;
//        if(copyOnRead){
//            CopyStrategyConfiguration copyStrategyConfiguration = new CopyStrategyConfiguration();
//            copyStrategyConfiguration.setClass("org.cam.core.cache.CloneCopyStrategy");
//            cfg.addCopyStrategy(copyStrategyConfiguration);
//        }
        return new Cache(cfg);
    }

    public static Cache addCache(Cache cache){
        return (Cache)cacheMgr.addCacheIfAbsent(cache);
    }
}
