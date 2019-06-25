package com.hirisun.springbootdemo.controller;

import com.hirisun.springbootdemo.bean.User;
import com.hirisun.springbootdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhoufeng
 * @create: 2019-06-21 15:19
 * @description:
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") long id) {
        log.debug("--> id:{}", id);
        return userService.getById(id);
    }

    @DeleteMapping("/users/{id}")
    public String delUserById(@PathVariable(value = "id") long id) {
        log.debug("--> id:{}", id);
        userService.delById(id);
        return "success";
    }
}
