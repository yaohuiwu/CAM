package org.cam.core.mock;

import org.cam.core.CamService;
import org.cam.core.FactoryHelper;
import org.cam.core.FlowHandler;
import org.cam.core.dao.PersistentDao;
import org.cam.core.domain.User;
import org.cam.core.domain.UserImpl;
import org.cam.core.impl.CamFactoryAdapter;
import org.cam.core.mapping.EntityTableMapping;
import org.cam.core.sql.SqlInterceptor;

/**
 * Created by wuyaohui on 14-10-9.
 */
public class MockCamFactory extends CamFactoryAdapter{

    private static final User MOCK_USER = new UserImpl("mock_user","mock_user");
    private static EntityTableMapping mapping ;

    public static MockCamFactory register(EntityTableMapping mapping){
        MockCamFactory mockCamFactory = new MockCamFactory();
        FactoryHelper.register(mockCamFactory);
        return mockCamFactory;
    }

    @Override
    public FlowHandler getFlowHandler() {
        return super.getFlowHandler();
    }

    @Override
    public User getCurrentUser() {
        return MOCK_USER;
    }

    @Override
    public CamService getService() {
        return super.getService();
    }

    @Override
    public PersistentDao getPersistentDao() {
        return super.getPersistentDao();
    }

    @Override
    public EntityTableMapping getEntityTableMapping() {
        return mapping;
    }

    @Override
    public SqlInterceptor getSqlInterceptor() {
        return super.getSqlInterceptor();
    }
}
