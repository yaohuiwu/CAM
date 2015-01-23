package org.cam.core.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.CopyStrategyConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration;
import org.cam.core.domain.StringSet;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.util.collections.Sets;

import static org.junit.Assert.*;
/**
 * Created by wuyaohui on 14-9-30.
 */
public class InnerCacheTest {
    @Test
    public void testCacheNames() throws Exception {

        assertEquals("user_role",InnerCache.user_role.toString());
        assertEquals("authorization",InnerCache.authorization.toString());
        assertEquals("permission",InnerCache.permission.toString());
    }

    @Test
    public void testCreateCacheManual() throws Exception {

        CacheConfiguration config = new CacheConfiguration();
        config.setName("queryListCache");
        config.setEternal(false);
        config.setMaxEntriesLocalHeap(1000);
        config.setTimeToLiveSeconds(3600);
        config.setTimeToIdleSeconds(3600);
        config.setCopyOnRead(false);
        config.setCopyOnWrite(true);
        config.setMemoryStoreEvictionPolicy("LRU");

        CopyStrategyConfiguration copyConfig = new CopyStrategyConfiguration();
        copyConfig.setClass("org.cam.core.cache.CloneCopyStrategy");
        config.addCopyStrategy(copyConfig);

        PersistenceConfiguration persistConfig = new PersistenceConfiguration();
        persistConfig.setStrategy("NONE");
        config.addPersistence(persistConfig);

        Cache cache = new Cache(config);

        CacheManager manager = CacheManager.getInstance();
        manager.addCache(cache);

        StringSet mySet = new StringSet(Sets.newSet("1","2"));
        cache.put(new Element("mySet",mySet));

        Element e = cache.get("mySet");
        Assert.assertNotNull(e);
        Assert.assertNotNull(e.getObjectValue());

        StringSet stringSet = (StringSet) e.getObjectValue();
        Assert.assertEquals(2 , stringSet.getIdSet().size());

        System.out.println(stringSet);
    }
}
