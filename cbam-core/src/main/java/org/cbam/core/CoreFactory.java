package org.cbam.core;

import org.cbam.core.meta.DAO;
import org.cbam.core.meta.impl.JdbcDAOImpl;
import org.cbam.core.parser.DefaultPermissionEvaluator;
import org.cbam.core.parser.PermissionEvaluator;

/**
 * Created by wuyaohui on 14-9-24.
 */
public class CoreFactory {

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
}
