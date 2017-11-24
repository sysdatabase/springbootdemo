package com.hirisun.springbootdemo.dao;

import com.hirisun.springbootdemo.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Long>,PermissionDao {

}
