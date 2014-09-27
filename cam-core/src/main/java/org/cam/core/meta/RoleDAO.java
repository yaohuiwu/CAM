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

}
