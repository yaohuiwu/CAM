package org.cam.core.cache;

import org.junit.Test;

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
}
