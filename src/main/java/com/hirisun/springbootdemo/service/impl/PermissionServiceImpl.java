package com.hirisun.springbootdemo.service.impl;

import com.hirisun.springbootdemo.bean.Permission;
import com.hirisun.springbootdemo.dao.PermissionRepository;
import com.hirisun.springbootdemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> getByUserId(long id) {
        return permissionRepository.getByUserId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(long id) {
        permissionRepository.deleteById(id);
    }
}
