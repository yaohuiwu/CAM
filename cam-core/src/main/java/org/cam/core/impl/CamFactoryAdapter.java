package org.cam.core.impl;

import org.cam.core.CamConfiguration;
import org.cam.core.CamFactory;
import org.cam.core.CamService;
import org.cam.core.FlowHandler;
import org.cam.core.dao.CamDao;
import org.cam.core.dao.PersistentDao;
import org.cam.core.domain.User;
import org.cam.core.mapping.EntityTableMapping;
import org.cam.core.sql.SqlInterceptor;

/**
 * Created by wuyaohui on 14-10-2.
 */
public class CamFactoryAdapter implements CamFactory{
    @Override
    public FlowHandler getFlowHandler() {
        return null;
    }

    @Override
    public User getCurrentUser() {
        return null;
    }

    @Override
    public CamService getService() {
        return null;
    }

    @Override
    public PersistentDao getPersistentDao() {
        return null;
    }

    @Override
    public EntityTableMapping getEntityTableMapping() {
        return null;
    }

    @Override
    public SqlInterceptor getSqlInterceptor() {
        return null;
    }

    @Override
    public CamConfiguration getConfiguration() {
        return null;
    }

    @Override
    public CamDao getCamDao() {
        return null;
    }
}
