package com.hirisun.springbootdemo.service;

import com.hirisun.springbootdemo.bean.User;

public interface UserService {

    /**
     * 根据用户名获得用户信息
     * @param username 用户名
     * @return 用户信息
     */
    User loadUserByUsername(String username);
}
