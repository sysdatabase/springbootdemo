package com.hirisun.springbootdemo.controller;

import com.hirisun.springbootdemo.bean.Permission;
import com.hirisun.springbootdemo.bean.Role;
import com.hirisun.springbootdemo.bean.User;
import com.hirisun.springbootdemo.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author: zhoufeng
 * @create: 2019-06-24 16:47
 * @description:
 */
@RestController
@Slf4j
public class RoleController {

    @Autowired
    private RoleService roleService;

    @DeleteMapping("/roles/{id}")
    @Transactional
    public String deleteById(@PathVariable("id") long id) {
        Role role = roleService.findById(id);
        Set<User> users = role.getUsers();
        users.forEach(u -> u.getRoles().remove(role));
        Set<Permission> permissions = role.getPermissions();
        permissions.forEach(p -> p.getRoles().remove(role));
        roleService.deleteById(id);
        return "success";
    }
}
