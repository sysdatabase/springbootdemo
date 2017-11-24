package com.hirisun.springbootdemo.service.impl;

import com.hirisun.springbootdemo.bean.User;
import com.hirisun.springbootdemo.service.PermissionService;
import com.hirisun.springbootdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SecurityUserDetailsService implements UserDetailsService{

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUserDetailsService.class);

    private UserService userService;

    private PermissionService permissionService;

    @Autowired
    public SecurityUserDetailsService(UserService userService, PermissionService permissionService){
        this.userService = userService;
        this.permissionService = permissionService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.debug("username:{}",username);
        if (StringUtils.isEmpty(username)){
            throw new UsernameNotFoundException("用户名不能为空！");
        }
        Optional<User> user = Optional.ofNullable(userService.loadUserByUsername(username));
        if (user.isPresent()){
            LOGGER.debug("User:{}",user.get().getId());
            Set<GrantedAuthority> authorities = new HashSet<>();
            permissionService.getByUserId(user.get().getId()).stream().forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getPermissionName())));
            return new org.springframework.security.core.userdetails.User(username,user.get().getPassword(),true,true,true,true,authorities);
        } else {
            return null;
        }
    }
}
