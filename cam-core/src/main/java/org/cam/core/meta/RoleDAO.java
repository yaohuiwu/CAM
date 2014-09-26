package org.cam.core.meta;

import org.cam.core.meta.domain.Role;

import java.util.List;

/**
 * Created by wuyaohui on 14-9-24.
 */
public interface RoleDAO {


    public List<Role> getAllRole();

    /**
     * Create given role.
     *
     * @param role
     * @return id of created role.
     */
    public int createRole(Role role);

    /**
     *
     * @param role
     * @return
     */
    public boolean updateRole(Role role);


    /**
     * Get role list of user.
     *
     * <p>
     *     This method will be heavily used by the first step of authorization.
     * </p>
     *
     * @param userId id of (login) user.
     * @return role list that user have.
     */
    public List<Role> getRolesOfUser(String userId);
}
