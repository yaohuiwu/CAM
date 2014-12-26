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

import java.util.Iterator;
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
        // Roles of user should be calculated in memory.

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
        //isEmpty does not mean miss hit.
        if(cachedRoleSet == null){
            LOG.debug("'user_role' Cache miss hit for user {}",user);
            cachedRoleSet = calculateRolesOfUser(user);
        }
        return camDao.getPermissionsOfRoles(cachedRoleSet,action,objectType);
    }

    @SuppressWarnings("unchecked")
    private Set<String> calculateRolesOfUser(User user){
        Set<Role> allRole = camDao.getAllRoleFromSor();
        Set<String> roleSet = Sets.newHashSet();
        Iterator<Role> it = allRole.iterator();
        while(it.hasNext()){
            Role role = it.next();
            if(evaluator.isPermit(user,role.toPermission().toString())){
                roleSet.add(role.getId());
            }
        }
        camDao.cacheRolesOfUser(user,roleSet);
        return roleSet;
    }
}
