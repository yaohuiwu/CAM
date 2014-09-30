package org.cam.core.cache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.cam.core.annotation.ExecutableType;
import org.cam.core.domain.Permission;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wuyaohui on 14-9-30.
 */
@Ignore
public class EhcacheHelperTest {

    Ehcache ehcache;

    @Before
    public void setUp() throws Exception {
        ehcache = CacheManager.getInstance().getEhcache(InnerCache.permission.toString());
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
}
