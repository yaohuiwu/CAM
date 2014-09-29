package org.cam.core.domain;

import org.cam.core.cache.Copyable;

import java.io.Serializable;
import java.util.Date;

/**
 * Which role can do what.
 */
public class Authorization implements Serializable,Copyable{

    private String id;
    private String roleId;
    private String permissionId;
    private Date updateTime;
    private String authorizedBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(String authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    @Override
    public Authorization copy() {
        Authorization a = new Authorization();
        a.setId(this.id);
        a.setRoleId(this.roleId);
        a.setPermissionId(this.permissionId);
        a.setAuthorizedBy(this.authorizedBy);
        a.setUpdateTime(this.updateTime);
        return a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authorization that = (Authorization) o;

        if (permissionId != null ? !permissionId.equals(that.permissionId) : that.permissionId != null) return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (permissionId != null ? permissionId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Authorization{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", permissionId='" + permissionId + '\'' +
                ", updateTime=" + updateTime +
                ", authorizedBy='" + authorizedBy + '\'' +
                '}';
    }
}
