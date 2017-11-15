package com.hirisun.springbootdemo.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "roleName")
    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
    @ManyToMany
    @JoinTable(name = "t_role_permission",joinColumns = {@JoinColumn(name = "r_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "p_id",referencedColumnName = "id")})
    private Set<Permission> permissions;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", users=" + users +
                ", permissions=" + permissions +
                '}';
    }
}
