package org.cam.core.meta.domain;

import org.cam.core.Copyable;

import java.io.Serializable;

/**
 * Do something on what.
 */
public class Permission implements Serializable,Copyable{

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (criteria != null ? !criteria.equals(that.criteria) : that.criteria != null) return false;
        if (objectType != null ? !objectType.equals(that.objectType) : that.objectType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = action != null ? action.hashCode() : 0;
        result = 31 * result + (objectType != null ? objectType.hashCode() : 0);
        result = 31 * result + (criteria != null ? criteria.hashCode() : 0);
        return result;
    }

    @Override
    public Object copy() {
        Permission p = new Permission(this.action,this.objectType,this.criteria);
        p.setId(this.id);
        return p;
    }
}
