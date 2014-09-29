package org.cam.core.impl;

import org.cam.core.CamService;
import org.cam.core.UserBehavior;
import org.cam.core.dao.CamDao;
import org.cam.core.domain.Permission;
import org.cam.core.domain.Role;
import org.cam.core.domain.User;
import org.cam.core.parser.PermissionEvaluator;

import java.util.Collections;
import java.util.List;

/**
 * Be careful for thread safety.
 */
public class CamServiceImpl implements CamService {

    private PermissionEvaluator evaluator;
    private CamDao camDao;

    public CamServiceImpl(PermissionEvaluator evaluator, CamDao dao){
        this.evaluator = evaluator;
        this.camDao = dao;
    }

    @Override
    public boolean isAllowed(UserBehavior entity) {
        boolean isAllowed = false;
//        List<Role> roleList = dao.getRolesOfUser(entity.getUserId());
        //TODO Roles of user should be calculated in memory.
        List<Role> roleList = Collections.emptyList();


//        for(Role role : roleList){
//            List<Permission> permissionList = dao.getPermissionsOf(role);
//            if(evaluator.isAnyPermit(entity.getExecutable(),permissionList)){
//                isAllowed = true ;
//                break;
//            }
//        }
        return isAllowed;
    }

    @Override
    public boolean isNotAllowed(UserBehavior entity) {
        return !isAllowed(entity);
    }

    @Override
    public List<Permission> getPermissionOfUser(User user, String action, String objectType) {

        //TODO getPermissionOfUser
        return Collections.emptyList();
    }
}
