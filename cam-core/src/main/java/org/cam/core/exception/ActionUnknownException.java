package org.cam.core.exception;

/**
 * Created by wuyaohui on 14-9-25.
 */
public class ActionUnknownException extends UserBehaviorException {

    public ActionUnknownException() {
    }

    public ActionUnknownException(String message) {
        super(message);
    }
}
