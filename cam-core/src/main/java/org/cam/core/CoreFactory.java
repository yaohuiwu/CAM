package org.cam.core;

import org.cam.core.dao.CamDao;
import org.cam.core.dao.CamDaoImpl;
import org.cam.core.dao.JdbcPersistentDaoImpl;
import org.cam.core.dao.PersistentDao;
import org.cam.core.domain.User;
import org.cam.core.impl.CamServiceImpl;
import org.cam.core.impl.CoreFlowHandler;
import org.cam.core.mapping.EntityTableMapping;
import org.cam.core.parser.DefaultPermissionEvaluator;

import javax.sql.DataSource;

/**
 * Factory for entire CBAM system , which is much like a spring BeanFactory.
 */
public class CoreFactory implements CamFactory{

    private  UserContextProvider _userContextProvider;
    private  FlowHandler _flowHandler;

    public CoreFactory(){
        DataSource ds = null;
        CamDao camDao = new CamDaoImpl(new JdbcPersistentDaoImpl(ds));
//        UserManagerProvider userManagerProvider = null;
        CamService service = new CamServiceImpl(new DefaultPermissionEvaluator(),camDao);
        _flowHandler = new CoreFlowHandler(service,null);
        FactoryHelper.register(this);
    }

    public  UserContextProvider getUserContextProvider(){
        if(_userContextProvider==null){
            throw new CamException("UserContextProvider not initialized.");
        }
        return _userContextProvider;
    }
    public FlowHandler getFlowHandler(){
        if(_flowHandler==null){
            throw new CamException("FlowHandler not initialized.");
        }
        return _flowHandler;
    }

    public User getCurrentUser(){
        return getUserContextProvider().getCurrentUser();
    }

//    @Override
//    public CoreDAO getCoreDao() {
//        return null;
//    }


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
