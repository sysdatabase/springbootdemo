package com.hirisun.springbootdemo.controller;

import com.hirisun.springbootdemo.bean.Role;
import com.hirisun.springbootdemo.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/roles/{id}")
    public Role getById(@PathVariable("id") long id){
        return roleService.findById(id);
    }

    @DeleteMapping("/roles/{id}")
    public String deleteById(@PathVariable("id") long id) {
        roleService.deleteById(id);
        return "success";
    }

    @PutMapping("/roles/{id}")
    public String update(@PathVariable("id") long id, @RequestBody Role role){
        roleService.update(id,role);
        return "success";
    }

}
