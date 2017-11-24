package com.hirisun.springbootdemo.dao.impl;

import com.hirisun.springbootdemo.bean.Permission;
import com.hirisun.springbootdemo.dao.PermissionDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class PermissionRepositoryImpl implements PermissionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Permission> getByUserId(long id) {
        String sql = "select p1.* from t_permission p1 right join (select p.p_id from t_role_permission p left join t_user_role r on p.r_id = r.r_id where r.u_id=?) p2 on p1.id = p2.p_id";
        Query query = entityManager.createNativeQuery(sql,Permission.class);
        query.setParameter(1,id);
        List<Permission> permissions = query.getResultList();
        return permissions;
    }
}
