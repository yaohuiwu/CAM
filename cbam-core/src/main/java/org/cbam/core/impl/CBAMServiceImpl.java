package org.cbam.core.impl;

import org.cbam.core.CoreFactory;
import org.cbam.core.DAO;
import org.cbam.core.UserBehavior;
import org.cbam.core.CBAMService;
import org.cbam.core.meta.domain.Permission;
import org.cbam.core.meta.domain.Role;
import org.cbam.core.parser.PermissionEvaluator;

import java.util.List;

/**
 * Be careful for thread safety.
 */
public class CBAMServiceImpl implements CBAMService {

    private PermissionEvaluator evaluator;
    private DAO dao;

    public CBAMServiceImpl(PermissionEvaluator evaluator,DAO dao){
        this.evaluator = evaluator;
        this.dao = dao;
    }

    @Override
    public boolean isAllowed(UserBehavior entity) {
        boolean isAllowed = false;
        List<Role> roleList = dao.getRolesOfUser(entity.getUserId());
        for(Role role : roleList){
            List<Permission> permissionList = dao.getPermissionsOf(role);
            if(evaluator.isAnyPermit(entity.getExecutable(),permissionList)){
                isAllowed = true ;
                break;
            }
        }
        return isAllowed;
    }

    @Override
    public boolean isNotAllowed(UserBehavior entity) {
        return !isAllowed(entity);
    }
}
