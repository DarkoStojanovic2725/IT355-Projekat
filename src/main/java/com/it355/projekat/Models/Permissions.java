package com.it355.projekat.Models;


import javax.persistence.*;

@Entity
@Table(name = "permissions")
public class Permissions {

    @Id
    @GeneratedValue
    private int permissionsId;
    private String username;
    private String permissionName;

    public int getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(int permissionsId) {
        this.permissionsId = permissionsId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
