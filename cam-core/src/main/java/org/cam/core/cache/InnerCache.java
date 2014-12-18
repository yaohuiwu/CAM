package org.cam.core.cache;

/**
 * Created by wuyaohui on 14-9-30.
 */
public enum InnerCache {

    /**
     * role set of user.
     */
    user_role ,

    /**
     * permissions of role
     */
    authorization,

    /**
     * permission
     */
    permission,

    /**
     * current user
     */
    cam_current_user,

    /**
     * query list cache.
     */
    cam_query_list
}
