package org.cam.core.cache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by wuyaohui on 14-9-29.
 */
public class CacheLoaderTest {

    private static final Logger LOG = LoggerFactory.getLogger(CacheLoaderTest.class);
    Ehcache ehcache;

    @Before
    public void setUp() throws Exception {
        ehcache = CacheManager.getInstance().getEhcache("permission");
        ehcache.removeAll();
    }

    @Test
    public void testGetWithLoader() throws Exception {
        String id = "perm_001";

        ehcache.load(id);

        Element e = ehcache.get(id);
        LOG.debug("get after load {}",id);
        assertNull(e);

        Element e2 = ehcache.getWithLoader(id,new CamCacheLoader(),null);
        assertNotNull(e2);
        assertNotNull(ehcache.get(id));
    }

}
