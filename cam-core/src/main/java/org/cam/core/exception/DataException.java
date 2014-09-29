package org.cam.core.exception;

import org.cam.core.CamException;

/**
 * Created by wuyaohui on 14-9-29.
 */
public class DataException extends CamException{

    public DataException() {
    }

    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataException(Throwable cause) {
        super(cause);
    }

}
