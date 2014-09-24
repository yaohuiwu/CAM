package org.cbam.core;

import org.cbam.core.exception.UserContextNotRegisteredException;
import org.cbam.core.impl.CBAMServiceImpl;
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

    public static PermissionEvaluator createPermissionEvaluator(){
        return new DefaultPermissionEvaluator();
    }

    public static DAO createDAO(){
        return createDAO(DAO.JDBC);
    }

    public static DAO createDAO(String type){
        if(DAO.JDBC.equals(type)){
            return new JdbcDAOImpl();
        }
        return null;
    }

    public static CBAMService createCBAMService(){
        return new CBAMServiceImpl(createPermissionEvaluator(),createDAO());
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

    public static User createUser(String id){
        return createUser(id,"unkown");
    }

    public static User createUser(String id ,String name){
        return new UserImpl(id,name);
    }

    public static Action createAction(String name,Object[] objects){
        return new Action(name,objects);
    }

    public static UserBehavior createUserBehavior(String userId,String actionName,Object[] objects){
        return new UserBehavior(createUser(userId),createAction(actionName,objects));
    }

    public static UserBehavior createUserBehavior(String actionName,Object[] objects){
        return new UserBehavior(getCurrentUser(),createAction(actionName,objects));
    }
}
