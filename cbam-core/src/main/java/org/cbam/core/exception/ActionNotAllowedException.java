package org.cbam.core.exception;

import org.cbam.core.CBAMException;
import org.cbam.core.UserBehavior;

public class ActionNotAllowedException extends CBAMException {

    private String userId;
    private String operation;
    private Object[] objects;

    public ActionNotAllowedException(String message){
        this(message,null);
    }

    public ActionNotAllowedException(String message, UserBehavior userBehavior) {
        super(message);
        this.userId = userBehavior.getUserId();
        this.operation = userBehavior.getExecutable().getName();
        this.objects = userBehavior.getExecutable().getObjects();
    }

    public String getUserId() {
        return userId;
    }

    public String getOperation() {
        return operation;
    }

    public Object[] getObjects() {
        return objects;
    }
}
