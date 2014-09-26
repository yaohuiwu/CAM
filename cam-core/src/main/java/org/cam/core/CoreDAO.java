package org.cam.core;

import org.cam.core.meta.AuthorizationDAO;
import org.cam.core.meta.PermissionDAO;
import org.cam.core.meta.RoleDAO;

/**
 * Authorization meta access interface using by CBAM system.
 */
public interface CoreDAO extends RoleDAO,PermissionDAO,AuthorizationDAO {

    public static final String JDBC = "jdbc";
    public static final String HIBERNATE = "hibernate";
}
