package org.cbam.core;

/**
 * Created by wuyaohui on 14-9-24.
 */

public interface CBAMService {


    /**
     * Is an AuthorizationEntity is allowed.
     *
     * @param userBehavior
     * @return
     */
    public boolean isAllowed(UserBehavior userBehavior);

    /**
     * Is an AuthorizationEntity is not allowed.
     *
     * @param userBehavior
     * @return
     */
    public boolean isNotAllowed(UserBehavior userBehavior);
}
