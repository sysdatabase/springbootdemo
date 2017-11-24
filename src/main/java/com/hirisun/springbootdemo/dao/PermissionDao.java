package com.hirisun.springbootdemo.dao;

import com.hirisun.springbootdemo.bean.Permission;

import java.util.List;

public interface PermissionDao {

    List<Permission> getByUserId(long id);
}
