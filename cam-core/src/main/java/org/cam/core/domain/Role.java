package org.cam.core.domain;

import org.cam.core.FactoryHelper;
import org.cam.core.annotation.ExecutableType;
import org.cam.core.cache.Copyable;

import java.io.Serializable;

/**
 * A collection of permissions.
 */
public class Role implements Serializable,Copyable{

    private String id;
    private String name;
    private String userCriteria;

    public Role() {
    }

    public Role(String name, String userCriteria) {
        this.name = name;
        this.userCriteria = userCriteria;
    }

    public Role(String id, String name, String userCriteria) {
        this.id = id;
        this.name = name;
        this.userCriteria = userCriteria;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (name != null ? !name.equals(role.name) : role.name != null) return false;
        if (userCriteria != null ? !userCriteria.equals(role.userCriteria) : role.userCriteria != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (userCriteria != null ? userCriteria.hashCode() : 0);
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Role copy() {
        Role r = new Role();
        r.setId(this.id);
        r.setName(this.name);
        r.setUserCriteria(this.userCriteria);
        return r;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userCriteria='" + userCriteria + '\'' +
                '}';
    }

    /**
     * Role can be seen as the permission of user.
     *
     * @return
     */
    public Permission toPermission(){
        return new Permission(ExecutableType.VIEW.toString(), FactoryHelper.getUserType(),getUserCriteria());
    }

}
