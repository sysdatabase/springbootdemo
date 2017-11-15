package com.hirisun.springbootdemo.service.impl;

import com.hirisun.springbootdemo.bean.User;
import com.hirisun.springbootdemo.dao.UserRepository;
import com.hirisun.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User loadUserByUsername(String username) {
        return userRepository.getByUsername(username);
    }
}
