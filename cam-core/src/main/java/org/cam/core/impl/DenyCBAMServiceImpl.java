package org.cam.core.impl;

import org.cam.core.CamService;
import org.cam.core.UserBehavior;

/**
 * Created by wuyaohui on 14-9-24.
 */
public class DenyCBAMServiceImpl implements CamService {

    @Override
    public boolean isAllowed(UserBehavior entity) {
        return false;
    }

    @Override
    public boolean isNotAllowed(UserBehavior entity) {
        return false;
    }
}
