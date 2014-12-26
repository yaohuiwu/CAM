package org.cam.core.exception;

import org.cam.core.CamException;
import org.cam.core.UserBehavior;

public class UserBehaviorException extends CamException {

    private UserBehavior userBehavior;

    public UserBehaviorException() {
    }

    public UserBehaviorException(String message) {
        super(message);
    }

    public UserBehaviorException(String message,UserBehavior userBehavior){
        this.userBehavior = userBehavior;
    }

    public UserBehaviorException(UserBehavior userBehavior, Throwable cause) {
        super(userBehavior.toString(), cause);
        this.userBehavior = userBehavior;
    }

    public UserBehavior getUserBehavior() {
        return userBehavior;
    }
}
