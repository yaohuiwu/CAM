package org.cbam.core.db.model;

/**
 * Created by wuyaohui on 14-9-23.
 */
public class UserImpl implements User{

    private String id;
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
