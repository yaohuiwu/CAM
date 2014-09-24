package org.cbam.core.meta;

/**
 * Authorization meta access interface using by CBAM system.
 */
public interface DAO extends RoleDAO,PermissionDAO,AuthorizationDAO {

    public static final String JDBC = "jdbc";
    public static final String HIBERNATE = "hibernate";
}
