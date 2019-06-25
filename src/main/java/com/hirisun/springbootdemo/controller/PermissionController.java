package com.hirisun.springbootdemo.controller;

import com.hirisun.springbootdemo.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhoufeng
 * @create: 2019-06-24 17:14
 * @description:
 */
@RestController
@Slf4j
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @DeleteMapping("/permissions/{id}")
    public String delete(@PathVariable("id") Long id){
        permissionService.deleteById(id);
        return "success";
    }
}
