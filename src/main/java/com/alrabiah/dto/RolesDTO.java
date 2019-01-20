package com.alrabiah.dto;

import com.alrabiah.entity.UsersEntity;

public class RolesDTO {

    private long roleid;
    private String rolename;
    private UsersEntity user;

    public long getRoleid() {
        return roleid;
    }

    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }
}
