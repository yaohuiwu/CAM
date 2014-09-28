package org.cam.core.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.cam.core.meta.domain.Role;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * Created by wuyaohui on 14-9-28.
 */
@Ignore
public class EhcacheTest {
    private static final Logger LOG = LoggerFactory.getLogger(EhcacheTest.class);

    @Test
    public void testCacheCfg() throws Exception {

        Cache roleCache = CacheUtils.createCopyOnReadMemoryOnlyCache("cam-role-cache", 1);

        final String id = "r1";
        Role r = new Role(id,"orgAdmin","org_id = '1'");

        Element e = new Element(r.getId(),r);
        roleCache.put(e);

        Element cpE = roleCache.get(id);
        Role cpR = (Role)cpE.getObjectValue();

        assertFalse(r == cpR);
        assertEquals(r,cpR);

        Role r2 = new Role("r2","orgAdmin","org_id = '1'");
        Element e2 = new Element(r2.getId(),r2);
        roleCache.put(e2);

        assertEquals(1,roleCache.getSize());
    }

    @Test
    public void testCacheCfg2() throws Exception {

        Cache roleCache = CacheUtils.createMemoryOnlyCache("cam-role", 1, false);
        CacheUtils.addCache(roleCache);

        final String id = "r1";
        Role r = new Role(id,"orgAdmin","org_id = '1'");

        Element e = new Element(r.getId(),r);
        roleCache.put(e);

        Element cpE = roleCache.get(id);
        Role cpR = (Role)cpE.getObjectValue();

        assertTrue(r == cpR);
    }

    @Test
    public void testReadThrough() throws Exception {
        Cache roleCache = CacheUtils.createMemoryOnlyCache("cam-role", 1, true);
        CacheDataAccessor<String,Role> myDAS = new CacheDataAccessor<>(roleCache);

        myDAS.readSomeData("r1");
    }

    @Test
    public void testWriteBehind() throws Exception {

        Cache roleCache = CacheUtils.createMemoryOnlyCache("cam-role", 1, true);

        CacheDataAccessor<String,Role> myDAS = new CacheDataAccessor<>(roleCache);


        myDAS.writeSomeData("r1",new Role("r1","admin","org_id=1"));
    }

    @Test
    public void testCacheIterator() throws Exception {

        Cache roleCache = CacheUtils.createCopyOnReadMemoryOnlyCache("cam-role-cache", 2);

        final String id = "r1";
        Role r = new Role(id,"orgAdmin","org_id = '1'");

        Element e = new Element(r.getId(),r);
        roleCache.put(e);

        Role r2 = new Role("r2","orgAdmin","org_id = '1'");
        Element e2 = new Element(r2.getId(),r2);
        roleCache.put(e2);

        assertEquals(2,roleCache.getSize());

    }
}
