package org.cam.proxy.hibernate;

import org.cam.core.FactoryHelper;
import org.hibernate.EmptyInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CamHbnInterceptor extends EmptyInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(CamHbnInterceptor.class);

    @Override
    public String onPrepareStatement(String sql) {
        if(LOG.isDebugEnabled()){
            LOG.debug(sql);
        }
        return FactoryHelper.factory().getSqlInterceptor().intercept(sql);
    }
}
