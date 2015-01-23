package org.cam.core.exception;

import org.cam.core.CamException;

/**
 * Created by wuyaohui on 15-1-16.
 */
public class EntityNotFoundException extends CamException{

    private String entityName;

    public EntityNotFoundException(String entityName) {
        super("entity " + String.valueOf(entityName) +" not found.");
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
