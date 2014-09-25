package org.cbam.core.meta.impl;

import org.cbam.core.CBAMException;
import org.cbam.core.CoreDAO;
import org.cbam.core.meta.domain.Authorization;
import org.cbam.core.meta.domain.Permission;
import org.cbam.core.meta.domain.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MarkerIgnoringBase;

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
            throw new CBAMException("DataSource not initialized.");
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
    public List<Role> getRolesOfUser(String userId) {
        return null;
    }

    @Override
    public List<Permission> getPermissionsOf(Role role) {
        return null;
    }
}
