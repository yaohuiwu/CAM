package org.cbam.core.meta.impl;

import org.cbam.core.meta.DAO;
import org.cbam.core.meta.domain.Authorization;
import org.cbam.core.meta.domain.Permission;
import org.cbam.core.meta.domain.Role;

import java.util.List;

/**
 * Created by wuyaohui on 14-9-24.
 */
public class JdbcDAOImpl implements DAO {

    @Override
    public List<Authorization> getAllAuthorization() {
        return null;
    }

    @Override
    public List<Permission> getAllPermission() {
        return null;
    }

    @Override
    public List<Role> getAllRole() {
        return null;
    }

    @Override
    public int createRole(Role role) {
        return 0;
    }

    @Override
    public boolean updateRole(Role role) {
        return false;
    }

    @Override
    public List<Role> getRolesOfUser(String userId) {
        return null;
    }
}
