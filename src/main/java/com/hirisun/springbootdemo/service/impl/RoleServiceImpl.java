package com.hirisun.springbootdemo.service.impl;

import com.hirisun.springbootdemo.bean.Role;
import com.hirisun.springbootdemo.dao.RoleRepository;
import com.hirisun.springbootdemo.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void deleteById(long id) {
        roleRepository.delete(id);
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id);
    }
}
