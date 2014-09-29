package org.cam.core.impl;

import com.google.common.collect.Sets;
import org.cam.core.CamService;
import org.cam.core.FactoryHelper;
import org.cam.core.UserBehavior;
import org.cam.core.dao.CamDao;
import org.cam.core.domain.Permission;
import org.cam.core.domain.Role;
import org.cam.core.domain.User;
import org.cam.core.parser.PermissionEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Be careful for thread safety.
 */
public class CamServiceImpl implements CamService {

    private static final Logger LOG = LoggerFactory.getLogger(CamServiceImpl.class);

    private PermissionEvaluator evaluator;
    private CamDao camDao;

    public CamServiceImpl(PermissionEvaluator evaluator, CamDao dao){
        this.evaluator = evaluator;
        this.camDao = dao;
    }

    @Override
    public boolean isAllowed(UserBehavior entity) {
        boolean isAllowed = false;
        //TODO Roles of user should be calculated in memory.

        List<Permission> permissions = getPermissionOfUser(FactoryHelper.currentUser(),entity.getExecutableName(),null);
        if(evaluator.isAnyPermit(entity.getExecutable(),permissions)){
            isAllowed = true;
        }
        return isAllowed;
    }

    @Override
    public boolean isNotAllowed(UserBehavior entity) {
        return !isAllowed(entity);
    }

    @Override
    public List<Permission> getPermissionOfUser(User user, String action, String objectType) {
        Set<String> cachedRoleSet =  camDao.getCachedRolesOfUser(user);
        if(cachedRoleSet==null){
            LOG.debug("'user_role' Cache miss hit for user {}",user);
            cachedRoleSet = calculateRolesOfUser(user);
        }else{
            LOG.debug("roles of {} found in cache.",user);
        }
        return camDao.getPermissionsOfRoles(cachedRoleSet,action,objectType);
    }

    private Set<String> calculateRolesOfUser(User user){
        //TODO calculateRolesOfUser


        camDao.cacheRolesOfUser(user,Collections.EMPTY_SET);
        return Collections.EMPTY_SET;
    }
}
