package org.cam.core.meta.domain;

import org.cam.core.cache.Copyable;

/**
 * Created by wuyaohui on 14-9-23.
 */
public class UserImpl implements User,Copyable{

    private String id;
    private String name;

    public UserImpl(String id) {
        this.id = id;
    }

    public UserImpl(String id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "UserImpl{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public UserImpl copy() {
        return new UserImpl(this.id,this.name);
    }
}
