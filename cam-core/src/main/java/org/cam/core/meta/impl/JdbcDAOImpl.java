package org.cam.core.meta.impl;

import org.cam.core.CamException;
import org.cam.core.CoreDAO;
import org.cam.core.meta.domain.Authorization;
import org.cam.core.meta.domain.Permission;
import org.cam.core.meta.domain.Role;
import org.cam.core.meta.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by wuyaohui on 14-9-24.
 */
public class JdbcDAOImpl implements CoreDAO {
    private static final Logger LOG = LoggerFactory.getLogger(JdbcDAOImpl.class);

    private DataSource dataSource;

    public JdbcDAOImpl(DataSource dataSource) {
        if(dataSource==null){
            throw new CamException("DataSource not initialized.");
        }
        LOG.info("DataSource initialized successfully.");
        this.dataSource = dataSource;
    }

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
    public List<Permission> getPermissionsOf(Role role) {
        return null;
    }

    @Override
    public List<Permission> getPermsOfUserByActionAndObjectType(User user, String action, String objectType) {
        return null;
    }
}
