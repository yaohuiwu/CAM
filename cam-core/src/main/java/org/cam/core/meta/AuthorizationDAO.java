package org.cam.core.meta;

import org.cam.core.meta.domain.Authorization;
import org.cam.core.meta.domain.Permission;
import org.cam.core.meta.domain.Role;
import org.cam.core.meta.domain.User;

import java.util.List;

/**
 * Created by wuyaohui on 14-9-24.
 */
public interface AuthorizationDAO {

    public List<Authorization> getAllAuthorization();

    public List<Permission> getPermsOfUserByActionAndObjectType(User user,String action,String objectType);

}
