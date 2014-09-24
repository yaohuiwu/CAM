package org.cbam.core;

import org.cbam.core.meta.AuthorizationDAO;
import org.cbam.core.meta.PermissionDAO;
import org.cbam.core.meta.RoleDAO;

/**
 * Authorization meta access interface using by CBAM system.
 */
public interface DAO extends RoleDAO,PermissionDAO,AuthorizationDAO {

    public static final String JDBC = "jdbc";
    public static final String HIBERNATE = "hibernate";
}
