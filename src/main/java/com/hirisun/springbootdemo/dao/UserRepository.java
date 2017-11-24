package com.hirisun.springbootdemo.dao;

import com.hirisun.springbootdemo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long>,UserDao{

    /**
     * 根据用户名获得用户信息
     * @param username 用户名
     * @return 用户信息
     */
    User getByUsername(String username);
}
