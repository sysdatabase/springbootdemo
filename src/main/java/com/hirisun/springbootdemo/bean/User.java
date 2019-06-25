package com.hirisun.springbootdemo.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "organization_id")
    private Organization organization;
    @ManyToMany
    @JoinTable(name = "t_user_role",joinColumns = {@JoinColumn(name = "u_id")},
            inverseJoinColumns = {@JoinColumn(name = "r_id")})
    private Set<Role> roles = new HashSet<Role>();
}
