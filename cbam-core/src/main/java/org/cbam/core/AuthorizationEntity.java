package org.cbam.core;

import org.cbam.core.meta.domain.Permission;

import java.util.List;

/**
 * Created by wuyaohui on 14-9-24.
 */
public class AuthorizationEntity {

    /**
     * Id of user.
     */
    private String userId;

    /**
     * Action of current execution.
     */
    private String action;

    /**
     * Object involved in current execution.
     */
    private Object object;

    public AuthorizationEntity() {
    }

    public AuthorizationEntity(String userId, String action, Object object) {
        this.userId = userId;
        this.action = action;
        this.object = object;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
