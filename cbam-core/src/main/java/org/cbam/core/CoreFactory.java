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

    private static UserContextProvider userContextProvider;

    public static CoreDAO createDAO(){
        return createDAO(CoreDAO.JDBC);
    }

    public static CoreDAO createDAO(String type){
        if(CoreDAO.JDBC.equals(type)){
            return new JdbcDAOImpl();
        }
        return null;
    }

    public static CBAMService createCBAMService(){
        return new CBAMServiceImpl(getPermissionEvaluator(),createDAO());
    }

    public static void registerUserContextProvider(UserContextProvider provider){
        userContextProvider = provider;
    }

    public static UserContextProvider getUserContextProvider(){
        return userContextProvider;
    }

    public static User getCurrentUser(){
        if(userContextProvider!=null){
            return userContextProvider.getCurrentUser();
        }else{
            throw new UserContextNotRegisteredException();
        }
    }

    public static UserBehavior createUserBehavior(String actionName,Object[] objects){
        return new UserBehavior(getCurrentUser(),createAction(actionName,objects));
    }

    public static FlowHandler getFlowHandler(){
        return new CenterFlowHandler(createCBAMService());
    }

    //-------private methods--------//

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
