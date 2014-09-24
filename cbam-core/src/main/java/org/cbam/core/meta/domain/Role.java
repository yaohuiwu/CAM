package org.cbam.core.meta.domain;

import java.io.Serializable;

/**
 * A collection of permissions.
 */
public class Role implements Serializable{

    private String id;
    private String name;
    private String userCriteria;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserCriteria() {
        return userCriteria;
    }

    public void setUserCriteria(String userCriteria) {
        this.userCriteria = userCriteria;
    }
}
