package org.cam.core;

import org.cam.core.dao.CamDao;
import org.cam.core.dao.CamDaoImpl;
import org.cam.core.dao.JdbcPersistentDaoImpl;
import org.cam.core.dao.PersistentDao;
import org.cam.core.domain.User;
import org.cam.core.impl.CamFactoryAdapter;
import org.cam.core.impl.CamServiceImpl;
import org.cam.core.impl.CoreFlowHandler;
import org.cam.core.mapping.EntityTableMapping;
import org.cam.core.parser.DefaultPermissionEvaluator;

import javax.sql.DataSource;

/**
 * Factory for entire CBAM system , which is much like a spring BeanFactory.
 */
public class CoreFactory extends CamFactoryAdapter{

    private  UserContextProvider userContextProvider;
    private  FlowHandler flowHandler;

    public CoreFactory(){
        DataSource ds = null;
        CamDao camDao = new CamDaoImpl(new JdbcPersistentDaoImpl(ds));
        CamService service = new CamServiceImpl(new DefaultPermissionEvaluator(),camDao);
        flowHandler = new CoreFlowHandler(service,null);
        FactoryHelper.register(this);
    }

    public  UserContextProvider getUserContextProvider(){
        if(userContextProvider ==null){
            throw new CamException("UserContextProvider not initialized.");
        }
        return userContextProvider;
    }
    public FlowHandler getFlowHandler(){
        if(flowHandler ==null){
            throw new CamException("FlowHandler not initialized.");
        }
        return flowHandler;
    }

    public User getCurrentUser(){
        return getUserContextProvider().getCurrentUser();
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
}
