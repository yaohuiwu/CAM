package org.cam.core.dao;

import org.cam.core.domain.Authorization;
import org.cam.core.domain.Permission;
import org.cam.core.domain.PermissionSet;
import org.cam.core.domain.Role;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public interface PersistentDao {

    public boolean isSorPrepared();

    public void initializeSor();

    /**
     * Ger all roles.
     *
     * @return
     */
    public List<Role> getAllRole();

    /**
     * Get authorization by role id set.
     * @param roleIdSet
     * @return
     */
    public Map<String,Set<Authorization>> getAuthorizationByRoles(Set<String> roleIdSet);

    /**
     * Get permissions by id set.
     *
     * @param permissionIdSet
     * @return
     */
    public List<Permission> getPermissions(Set<String> permissionIdSet);

    /**
     * Single permission.
     *
     * @param permissionId
     * @return
     */
    public Permission getSinglePermission(String permissionId);

    /**
     * Get permission set of role with give role id.
     *
     * @param roleId
     * @return
     */
    public PermissionSet getPermissionOfRole(String roleId);

}
