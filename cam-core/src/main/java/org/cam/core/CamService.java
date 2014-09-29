package org.cam.core;

import org.cam.core.domain.Permission;
import org.cam.core.domain.User;

import java.util.List;

/**
 * Created by wuyaohui on 14-9-24.
 */

public interface CamService {


    /**
     * Is given UserBehavior is allowed.
     *
     * @param userBehavior
     * @return
     */
    public boolean isAllowed(UserBehavior userBehavior);

    /**
     * Is given UserBehavior is not allowed.
     *
     * @param userBehavior
     * @return
     */
    public boolean isNotAllowed(UserBehavior userBehavior);

    /**
     * Get permissions of user with given action and objectType.
     *
     * @param user
     * @param action
     * @param objectType
     * @return
     */
    public List<Permission> getPermissionOfUser(User user,String action,String objectType);
}
