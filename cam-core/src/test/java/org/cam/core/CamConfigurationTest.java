package org.cam.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yaohui on 15-1-23.
 */
public class CamConfigurationTest {

    @Test
    public void testDefault(){

        CamConfiguration cfg = new CamConfiguration();
        Assert.assertEquals(Boolean.FALSE, cfg.isPassWithNoPermission());
        Assert.assertEquals(Boolean.FALSE, cfg.isAllowNoEntityOfTable());
        Assert.assertEquals(Boolean.TRUE, cfg.isEnableQueryListCache());
    }

    @Test
    public void testAnother(){

        CamConfiguration cfg = new CamConfiguration("camOther.properties");
        Assert.assertEquals(Boolean.TRUE, cfg.isPassWithNoPermission());
        Assert.assertEquals(Boolean.TRUE, cfg.isAllowNoEntityOfTable());
        Assert.assertEquals(Boolean.FALSE, cfg.isEnableQueryListCache());
    }
}
