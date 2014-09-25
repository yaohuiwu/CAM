package org.cbam.core;

import org.cbam.core.exception.UserContextNotRegisteredException;
import org.cbam.core.impl.CBAMServiceImpl;
import org.cbam.core.impl.CenterFlowHandler;
import org.cbam.core.meta.domain.User;
import org.cbam.core.meta.domain.UserImpl;
import org.cbam.core.meta.impl.JdbcDAOImpl;
import org.cbam.core.parser.DefaultPermissionEvaluator;
import org.cbam.core.parser.PermissionEvaluator;

/**
 * Factory for entire CBAM system , which is much like a spring BeanFactory.
 */
public class CoreFactory {

    private static UserContextProvider _userContextProvider;
    private static FlowHandler _flowHandler;

    public static void registerUserContextProvider(UserContextProvider provider){
        _userContextProvider = provider;
    }

    public static void registerFlowHandler(FlowHandler flowHandler){
        _flowHandler = flowHandler;
    }

    public static UserContextProvider getUserContextProvider(){
        if(_userContextProvider==null){
            throw new CBAMException("UserContextProvider not initialized.");
        }
        return _userContextProvider;
    }
    public static FlowHandler getFlowHandler(){
        if(_flowHandler==null){
            throw new CBAMException("FlowHandler not initialized.");
        }
        return _flowHandler;
    }

    public static User getCurrentUser(){
        return getUserContextProvider().getCurrentUser();
    }

    public static UserBehavior createUserBehavior(String actionName,Object[] objects){
        return new UserBehavior(getCurrentUser(),createAction(actionName,objects));
    }

    //-------private methods--------//

    private static CoreDAO createDAO(){
        return createDAO(CoreDAO.JDBC);
    }

    private static CoreDAO createDAO(String type){
        if(CoreDAO.JDBC.equals(type)){
            return new JdbcDAOImpl();
        }
        return null;
    }

    private static CBAMService createCBAMService(){
        return new CBAMServiceImpl(getPermissionEvaluator(),createDAO());
    }

    private static PermissionEvaluator getPermissionEvaluator(){
        return new DefaultPermissionEvaluator();
    }

    private static User createUser(String id){
        return createUser(id,"unkown");
    }

    private static User createUser(String id ,String name){
        return new UserImpl(id,name);
    }

    private static Action createAction(String name,Object[] objects){
        return new Action(name,objects);
    }

    private static UserBehavior createUserBehavior(String userId,String actionName,Object[] objects){
        return new UserBehavior(createUser(userId),createAction(actionName,objects));
    }
}
