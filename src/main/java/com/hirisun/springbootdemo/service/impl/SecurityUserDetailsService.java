package com.hirisun.springbootdemo.service.impl;

import com.hirisun.springbootdemo.bean.User;
import com.hirisun.springbootdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

@Service
public class SecurityUserDetailsService implements UserDetailsService{

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUserDetailsService.class);

    private UserService userService;

    @Autowired
    public SecurityUserDetailsService(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.debug("username:{}",username);
        if (StringUtils.isEmpty(username)){
            throw new UsernameNotFoundException("用户名不能为空！");
        }
        User user = userService.loadUserByUsername(username);
        LOGGER.debug("User:{}",user.getId());
        Set<GrantedAuthority> authorities = new HashSet<>();

        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),true,true,true,true,authorities);
    }
}
