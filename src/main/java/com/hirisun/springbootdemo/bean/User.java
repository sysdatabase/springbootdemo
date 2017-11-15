package com.hirisun.springbootdemo.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "t_user_role",joinColumns = {@JoinColumn(name = "u_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "r_id",referencedColumnName = "id")})
    private Set<Role> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
