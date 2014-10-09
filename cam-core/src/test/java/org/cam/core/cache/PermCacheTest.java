package org.cam.core.cache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.cam.core.action.annotation.ExecutableType;
import org.cam.core.domain.Permission;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * Created by wuyaohui on 14-9-28.
 */
@Ignore
public class PermCacheTest {
    private static final Logger LOG = LoggerFactory.getLogger(PermCacheTest.class);

    Ehcache permCache = null;

    @Before
    public void setUp() throws Exception {
        CacheManager cacheMgr = CacheManager.getInstance();
        permCache = cacheMgr.getEhcache(InnerCache.permission.toString());
        assertNotNull(permCache);

        permCache.removeAll();
    }

    @Test
    public void testCopyOnReadCache() throws Exception {
        Permission p = new Permission(ExecutableType.VIEW.toString(),"User","org_id=1");
        p.setId("perm_001");

        Element e = new Element(p.getId(),p);
        permCache.put(e);

        Element eCopy = permCache.get("perm_001");
        assertFalse(p == eCopy.getObjectValue());
        assertEquals(p,eCopy.getObjectValue());
    }

    @Test
    public void testCopyOnWrite() throws Exception {
        Permission p = new Permission(ExecutableType.VIEW.toString(),"User","org_id=1");
        p.setId("perm_001");

        Element e = new Element(p.getId(),p);
        permCache.put(e);

        p.setAction(ExecutableType.CREATE.toString());

        Element eCopy = permCache.get("perm_001");
        assertNotEquals(p, eCopy.getObjectValue());
    }

    @Test
    public void testWriteThrough() throws Exception {
        Permission p = new Permission(ExecutableType.VIEW.toString(),"User","org_id=1");
        p.setId("perm_001");

        Element e = new Element(p.getId(),p);
//        permCache.put(e);
        permCache.putWithWriter(e);
    }
}
