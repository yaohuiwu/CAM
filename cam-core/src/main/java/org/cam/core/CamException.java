package org.cam.core;

/**
 * Created by wuyaohui on 14-9-24.
 */
public class CamException extends RuntimeException{

    public CamException() {
    }

    public CamException(String message) {
        super(message);
    }

    public CamException(String message, Throwable cause) {
        super(message, cause);
    }

    public CamException(Throwable cause) {
        super(cause);
    }

    public CamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
