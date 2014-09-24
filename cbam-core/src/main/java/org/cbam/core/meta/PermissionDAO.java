package org.cbam.core.meta;

import org.cbam.core.meta.domain.Permission;
import org.cbam.core.meta.domain.Role;

import java.util.List;

/**
 * Created by wuyaohui on 14-9-24.
 */
public interface PermissionDAO {

    List<Permission> getAllPermission();

    List<Permission> getPermissionsOf(Role role);
}
