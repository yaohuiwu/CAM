package org.cbam.core.exception;

import org.cbam.core.CBAMException;

public class ActionNotAllowedException extends CBAMException {

    private String userId;
    private String operation;
    private Object object;

    public ActionNotAllowedException(String message){
        this(message,null,null,null);
    }

    public ActionNotAllowedException(String message, String userId, String operation, Object object) {
        super(message);
        this.userId = userId;
        this.operation = operation;
        this.object = object;
    }

    public String getUserId() {
        return userId;
    }

    public String getOperation() {
        return operation;
    }

    public Object getObject() {
        return object;
    }
}
