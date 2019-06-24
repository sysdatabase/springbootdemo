package com.hirisun.springbootdemo.service;

import com.hirisun.springbootdemo.bean.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> getByUserId(long id);

    void deleteById(long id);
}
