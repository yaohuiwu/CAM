package org.cbam.core.impl;

import org.cbam.core.AuthorizationEntity;
import org.cbam.core.CBAMService;

/**
 * Created by wuyaohui on 14-9-24.
 */
public class CBAMServiceImpl implements CBAMService {

    @Override
    public boolean isAllowed(AuthorizationEntity entity) {
        //get user role by id
        //entity.getUserId();


        return false;
    }

    @Override
    public boolean isNotAllowed(AuthorizationEntity entity) {
        return false;
    }
}
