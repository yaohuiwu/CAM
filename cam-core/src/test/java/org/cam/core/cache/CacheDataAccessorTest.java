package org.cam.core.cache;

import com.google.common.collect.Sets;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import org.cam.core.annotation.ExecutableType;
import org.cam.core.meta.domain.Permission;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wuyaohui on 14-9-29.
 */
public class CacheDataAccessorTest {

    CacheDataAccessor<String,Permission> accessor ;

    @Before
    public void setUp() throws Exception {
        Ehcache ehcache = CacheManager.getInstance().getEhcache("permission");
        accessor = new CacheDataAccessor<>(ehcache);
        ehcache.removeAll();
    }

    @Test
    public void testReadWriteDelete() throws Exception {
        Permission p = accessor.get("perm_001");
        assertNull(p);

        p = new Permission(ExecutableType.CREATE.toString(),"User","org_id=1");
        p.setId("perm_001");
        accessor.write(p.getId(),p);

        assertNotNull(accessor.get(p.getId()));

        accessor.delete(p.getId());
        assertNull(accessor.get(p.getId()));
    }

    @Test
    public void testGetAll() throws Exception {
        List<Permission> lists = accessor.getAll(Sets.newHashSet("perm_001","perm_002"));
    }
}
