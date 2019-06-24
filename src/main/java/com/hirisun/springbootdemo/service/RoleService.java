package com.hirisun.springbootdemo.service;

import com.hirisun.springbootdemo.bean.Role;

public interface RoleService {

    void deleteById(long id);

    Role findById(long id);
}
