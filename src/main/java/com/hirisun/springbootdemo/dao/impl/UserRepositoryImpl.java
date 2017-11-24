package com.hirisun.springbootdemo.dao.impl;

import com.hirisun.springbootdemo.dao.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserRepositoryImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
}
