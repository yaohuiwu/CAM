package org.cbam.core;

/**
 * Created by wuyaohui on 14-9-24.
 */

public interface CBAMService {


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
}
