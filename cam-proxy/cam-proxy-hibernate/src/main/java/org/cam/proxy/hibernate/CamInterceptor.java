package org.cam.proxy.hibernate;

import org.hibernate.EmptyInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wuyaohui on 14-10-8.
 */
public class CamInterceptor extends EmptyInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(CamInterceptor.class);

    @Override
    public String onPrepareStatement(String sql) {

        LOG.debug("before onPrepareStatement");
        return super.onPrepareStatement(sql);
    }
}
