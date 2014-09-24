package org.cbam.core.impl;

import org.cbam.core.CBAMService;
import org.cbam.core.UserBehavior;

/**
 * Created by wuyaohui on 14-9-24.
 */
public class DenyCBAMServiceImpl implements CBAMService{

    @Override
    public boolean isAllowed(UserBehavior entity) {
        return false;
    }

    @Override
    public boolean isNotAllowed(UserBehavior entity) {
        return false;
    }
}
