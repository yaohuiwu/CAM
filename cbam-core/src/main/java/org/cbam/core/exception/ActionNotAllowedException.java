package org.cbam.core.exception;

import org.cbam.core.UserBehavior;

public class ActionNotAllowedException extends UserBehaviorException {

    private UserBehavior userBehavior;

    public ActionNotAllowedException(String message){
        this(message,null);
    }

    public ActionNotAllowedException(String message, UserBehavior userBehavior) {
        super(message);
        this.userBehavior = userBehavior;
    }

    public UserBehavior getUserBehavior() {
        return userBehavior;
    }

    @Override
    public String toString() {
        return "ActionNotAllowedException{" +
                "userBehavior=" + userBehavior +
                '}';
    }
}
