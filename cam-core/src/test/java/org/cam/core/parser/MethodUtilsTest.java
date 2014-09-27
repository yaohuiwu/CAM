package org.cam.core.parser;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yaohui on 14-9-21.
 */
public class MethodUtilsTest {

    @Test
    public void testGetter() throws Exception{
        User u = new User(18);

        Object val = MethodUtils.invokeMethod(u,"getAge");
        Assert.assertNotNull(val);
        Assert.assertTrue(val instanceof Integer);
        Assert.assertTrue(val.equals(18));
    }
}
