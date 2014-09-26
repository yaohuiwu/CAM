package org.cam.core;

import org.cam.core.impl.CamServiceImpl;
import org.cam.core.impl.CoreFlowHandler;
import org.cam.core.meta.domain.User;
import org.cam.core.meta.domain.UserImpl;
import org.cam.core.meta.impl.JdbcDAOImpl;
import org.cam.core.parser.DefaultPermissionEvaluator;
import org.cam.core.parser.PermissionEvaluator;

import javax.sql.DataSource;

/**
 * Factory for entire CBAM system , which is much like a spring BeanFactory.
 */
public class CoreFactory implements CamFactory{

    private  UserContextProvider _userContextProvider;
    private  FlowHandler _flowHandler;

    public CoreFactory(){
        DataSource ds = null;
        CamService service = new CamServiceImpl(new DefaultPermissionEvaluator(),new JdbcDAOImpl(ds));
        FlowHandler flowHandler = new CoreFlowHandler(service,null);
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

}
