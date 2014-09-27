package org.cam.core.impl;

import org.cam.core.CamService;
import org.cam.core.CoreDAO;
import org.cam.core.UserBehavior;
import org.cam.core.meta.domain.Permission;
import org.cam.core.meta.domain.Role;
import org.cam.core.parser.PermissionEvaluator;

import java.util.Collections;
import java.util.List;

/**
 * Be careful for thread safety.
 */
public class CamServiceImpl implements CamService {

    private PermissionEvaluator evaluator;
    private CoreDAO dao;

    public CamServiceImpl(PermissionEvaluator evaluator, CoreDAO dao){
        this.evaluator = evaluator;
        this.dao = dao;
    }

    @Override
    public boolean isAllowed(UserBehavior entity) {
        boolean isAllowed = false;
//        List<Role> roleList = dao.getRolesOfUser(entity.getUserId());
        //TODO Roles of user should be calculated in memory.
        List<Role> roleList = Collections.emptyList();

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
