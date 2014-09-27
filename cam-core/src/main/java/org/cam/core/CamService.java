package org.cam.core;

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
}