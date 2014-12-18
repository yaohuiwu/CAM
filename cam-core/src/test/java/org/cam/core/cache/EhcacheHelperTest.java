package org.cam.core.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.cam.core.action.annotation.ExecutableType;
import org.cam.core.domain.Permission;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wuyaohui on 14-9-30.
 */
//@Ignore
public class EhcacheHelperTest {

    Ehcache ehcache;

    @Before
    public void setUp() throws Exception {
        CacheManager cacheManager = Caches.getCacheManager();
        ehcache = cacheManager.getEhcache(InnerCache.permission.toString());
        ehcache.removeAll();
    }

    @Test
    public void testGetValue() throws Exception {

        Permission p = new Permission(ExecutableType.CREATE.toString(),"User","org_id = 1");
        p.setId("p1");
        ehcache.put(new Element(p.getId(),p));

        Permission gtPerm = Caches.get("p1", Permission.class, ehcache);
        assertNotNull(gtPerm);
        assertEquals(p,gtPerm);
    }

    @Test
    public void testCreateCacheManager() throws Exception {
        CacheManager cacheManager = Caches.getCacheManager();
        assertNotNull(cacheManager);

        Cache user_role = cacheManager.getCache(InnerCache.user_role.toString());
        assertNotNull(user_role);

        Cache perm = cacheManager.getCache(InnerCache.permission.toString());
        assertNotNull(perm);

        Cache auth = cacheManager.getCache(InnerCache.authorization.toString());
        assertNotNull(auth);

        Cache aa = cacheManager.getCache(InnerCache.cam_current_user.toString());
        assertNotNull(aa);
    }
}
