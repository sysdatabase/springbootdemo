package com.hirisun.springbootdemo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_role")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "roleName")
    private String roleName;
    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<User>();
    @ManyToMany
    @JoinTable(name = "t_permission_role",joinColumns = {@JoinColumn(name = "p_id")},
            inverseJoinColumns = {@JoinColumn(name = "r_id")})
    private Set<Permission> permissions = new HashSet<Permission> ();
}
