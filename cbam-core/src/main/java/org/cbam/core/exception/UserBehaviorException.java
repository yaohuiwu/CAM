package org.cbam.core.exception;

import org.cbam.core.CBAMException;
import org.cbam.core.UserBehavior;

public class UserBehaviorException extends CBAMException{

    private UserBehavior userBehavior;

    public UserBehaviorException() {
    }

    public UserBehaviorException(String message) {
        super(message);
    }

    public UserBehaviorException(String message,UserBehavior userBehavior){
        this.userBehavior = userBehavior;
    }

    public UserBehavior getUserBehavior() {
        return userBehavior;
    }
}
