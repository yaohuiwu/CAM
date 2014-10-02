package org.cam.core.exception;

import org.cam.core.CamException;

/**
 * Created by wuyaohui on 14-9-29.
 */
public class ParserException extends CamException{

    public ParserException() {
    }

    public ParserException(String message) {
        super(message);
    }

    public ParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParserException(Throwable cause) {
        super(cause);
    }

}
