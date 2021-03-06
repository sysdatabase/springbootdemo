package com.hirisun.springbootdemo.service.impl;

import com.hirisun.springbootdemo.bean.User;
import com.hirisun.springbootdemo.service.PermissionService;
import com.hirisun.springbootdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SecurityUserDetailsService implements UserDetailsService{


    private UserService userService;

    private PermissionService permissionService;

    @Autowired
    public SecurityUserDetailsService(UserService userService, PermissionService permissionService){
        this.userService = userService;
        this.permissionService = permissionService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("username:{}",username);
        if (StringUtils.isEmpty(username)){
            throw new UsernameNotFoundException("用户名不能为空！");
        }
        Optional<User> user = Optional.ofNullable(userService.loadUserByUsername(username));
        if (user.isPresent()){
            log.debug("User:{}",user.get().getId());
            Set<SimpleGrantedAuthority> authorities = permissionService.getByUserId(user.get().getId()).stream().map(permission -> permission.getPermissionName()).map(p -> new SimpleGrantedAuthority("ROLE_"+p)).collect(Collectors.toSet());
            return new org.springframework.security.core.userdetails.User(username,user.get().getPassword(),true,true,true,true,authorities);
        } else {
            return null;
        }
    }
}
