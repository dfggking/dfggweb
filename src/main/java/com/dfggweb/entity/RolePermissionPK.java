package com.dfggweb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jinyf on 2017/10/27.
 */
public class RolePermissionPK implements Serializable {
    private int id;
    private int roleId;
    private int permissionId;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "role_id")
    @Id
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Column(name = "permission_id")
    @Id
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePermissionPK that = (RolePermissionPK) o;

        if (id != that.id) return false;
        if (roleId != that.roleId) return false;
        if (permissionId != that.permissionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + roleId;
        result = 31 * result + permissionId;
        return result;
    }
}
