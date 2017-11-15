package com.hirisun.springbootdemo.dao;

import com.hirisun.springbootdemo.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
