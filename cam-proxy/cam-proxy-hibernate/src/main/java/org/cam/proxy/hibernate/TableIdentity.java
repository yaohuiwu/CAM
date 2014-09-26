package org.cam.proxy.hibernate;

/**
 * Created by wuyaohui on 14-9-26.
 */
public class TableIdentity {

    private String entity;
    private String name ;

    public TableIdentity(String entity, String name) {
        this.entity = entity;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }
}
