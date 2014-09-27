package org.cam.core.meta.domain;

import java.io.Serializable;

/**
 * Do something on what.
 */
public class Permission implements Serializable{

    private String id;
    private String action;
    private String objectType;
    private String criteria;

    public Permission() {
    }

    public Permission(String action, String objectType, String criteria) {
        this.action = action;
        this.objectType = objectType;
        this.criteria = criteria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(action);
        s.append(":");
        s.append(objectType);
        s.append(":");
        s.append(criteria);
        return s.toString();
    }
}
