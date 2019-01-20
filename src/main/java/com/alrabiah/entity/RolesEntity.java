package com.alrabiah.entity;

import javax.persistence.*;


@Entity
@Table(name="ROLES")
public class RolesEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleid;
    private String rolename;
    @ManyToOne
    @JoinColumn(name = "username",referencedColumnName = "username")
    private UsersEntity user;

    public long getRoleid() { return roleid; }

    public void setRoleid(long roleid) { this.roleid = roleid; }

    public String getRolename() { return rolename; }

    public void setRolename(String rolename) { this.rolename = rolename; }

    public UsersEntity getUser() { return user; }

    public void setUser(UsersEntity user) { this.user = user; }
}