package org.cam.core.impl;

import org.cam.core.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserContextProviderImpl extends ThreadLocalUserContext {

    private static final Logger LOG = LoggerFactory.getLogger(UserContextProviderImpl.class);

    @Override
    public void setCurrentUser(User user) {
        if(user==null){
            User existUser = getThreadUser();
            LOG.debug("remove CAM thread local user:'{}'",existUser!=null?existUser.getName():null);
            removeThreadUser();
        }else{
            LOG.debug("Set CAM thread local user:'{}'", user.getName());
            setThreadUser(user);
        }
    }
}
