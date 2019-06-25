package com.hirisun.springbootdemo.service.impl;

import com.hirisun.springbootdemo.bean.Permission;
import com.hirisun.springbootdemo.bean.Role;
import com.hirisun.springbootdemo.bean.User;
import com.hirisun.springbootdemo.dao.RoleRepository;
import com.hirisun.springbootdemo.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author: zhoufeng
 * @create: 2019-06-24 15:39
 * @description:
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(long id) {
        Role role = this.findById(id);
        Set<User> users = role.getUsers();
        users.forEach(u -> u.getRoles().remove(role));
        Set<Permission> permissions = role.getPermissions();
        permissions.forEach(p -> p.getRoles().remove(role));
        roleRepository.deleteById(id);
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(long id,Role role) {
        Role role1 = this.findById(id);
        BeanUtils.copyProperties(role,role1);
    }
}
