package org.cam.core.impl;

import org.cam.core.CamService;
import org.cam.core.UserBehavior;
import org.cam.core.domain.Permission;
import org.cam.core.domain.User;

import java.util.Collections;
import java.util.List;

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

    @Override
    public List<Permission> getPermissionOfUser(User user, String action, String objectType) {
        return Collections.emptyList();
    }
}
