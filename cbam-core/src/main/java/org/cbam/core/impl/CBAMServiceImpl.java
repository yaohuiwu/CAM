package org.cbam.core.impl;

import org.cbam.core.UserBehavior;
import org.cbam.core.CBAMService;

/**
 * Created by wuyaohui on 14-9-24.
 */
public class CBAMServiceImpl implements CBAMService {

    @Override
    public boolean isAllowed(UserBehavior entity) {
        //get user role by id
        //entity.getUserId();


        return false;
    }

    @Override
    public boolean isNotAllowed(UserBehavior entity) {
        return false;
    }
}
