package com.hirisun.springbootdemo.service;

import com.hirisun.springbootdemo.bean.User;
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

    @Autowired
    private UserService userServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.debug("username:{}",username);
        if (StringUtils.isEmpty(username)){
            throw new UsernameNotFoundException("用户名不能为空！");
        }
        User user = userServiceImpl.loadUserByUsername(username);
        LOGGER.debug("User:{}",user.getId());
        Set<GrantedAuthority> authorities = new HashSet<>();

        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),true,true,true,true,authorities);
    }
}
