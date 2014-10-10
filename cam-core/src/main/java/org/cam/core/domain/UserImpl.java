package org.cam.core.domain;

import org.cam.core.cache.Copyable;

/**
 * Created by wuyaohui on 14-9-23.
 */
public class UserImpl implements User,Copyable{

    public static final User ANONYMOUS_USER = new UserImpl("anonymous_user","anonymous_user");

    private String id;
    private String name;

//    public UserImpl(String id) {
//        this.id = id;
//    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserImpl user = (UserImpl) o;

        if (!id.equals(user.id)) return false;
        if (!name.equals(user.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
