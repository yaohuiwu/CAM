package org.cam.core.dao;

import org.cam.core.domain.Permission;
import org.cam.core.domain.Role;
import org.cam.core.domain.User;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A Dao that will be used directly by core CAM system.
 */
public interface CamDao {

    /**
     * Get roles of user.
     *
     * @param user
     * @return roles list
     */
    public Set<String> getCachedRolesOfUser(User user);


    /**
     * Get all roles from system of record.
     *
     * <p>
     *     This method will be used when there is no roles of user found in cache , which means you must calculate them
     *     by hand.
     * </p>
     *
     * @return set of roles.
     */
    public Set<Role> getAllRoleFromSor();


    /**
     * Cache roles of user.
     * <p>
     *     Because calculate roles of user could be a resource consuming task , after you calculate roles of a user ,
     *     Please put into cache for future use.
     * </p>
     *
     * @param user that user.
     * @param roles his roles.
     */
    public void cacheRolesOfUser(User user,Set<String> roles);


    /**
     * Get permission id set of role.
     *
     * @param roleId  id of that role.
     * @return
     */
    public Set<String> getPermissionIdsOfRole(String roleId);

    /**
     * Get permission id set of role set.
     *
     * @param roleSet set of role id.
     * @return a map with role id as key and permission id set as value.
     */
    public Map<String,Set<String>> getPermissionsIdOfRoles(Set<String> roleSet);


    /**
     * Get a single permission.
     *
     * @param permissionId
     * @return
     */
    public Permission getSinglePermission(String permissionId);

    /**
     * Get permissions of roles with action and objectType.
     * @param roleIdSet
     * @param action
     * @param objectType
     * @return
     */
    public List<Permission> getPermissionsOfRoles(Set<String> roleIdSet,String action,String objectType);

    /**
     * Fetch single column list from sor.
     *
     * @param queryString
     * @return if multiple columns found. just return the first column.
     */
    public Collection<String> singleColumnListQuery(String queryString);

}
