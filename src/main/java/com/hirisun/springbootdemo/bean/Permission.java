package com.hirisun.springbootdemo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_permission")
@Getter
@Setter
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "permissionName")
    private String permissionName;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "t_permission_role",joinColumns = {@JoinColumn(name = "p_id")},
            inverseJoinColumns = {@JoinColumn(name = "r_id")})
    private Set<Role> roles = new HashSet<Role>();
}
