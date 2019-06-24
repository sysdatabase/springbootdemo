package com.hirisun.springbootdemo.bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhoufeng
 * @create: 2019-06-24 16:00
 * @description:
 */
@Entity
@Table(name = "t_organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 64)
    private String name;

    @Column(length = 64)
    private String code;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Organization parent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Set<Organization> children = new HashSet<>();

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();
}
