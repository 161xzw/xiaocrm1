package com.xiao.crm.service.impl;

import com.xiao.crm.dao.IRolePermissionDao;
import com.xiao.crm.domain.RolePermission;
import com.xiao.crm.service.IRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("rolePermissionService")
public class RolePermissionServiceImpl implements IRolePermissionService {

    @Autowired
    private IRolePermissionDao rolePermissionDao;

    @Override
    public List<RolePermission> findAll(int page, int limit,int roleId) {
        return rolePermissionDao.findAll(page,limit,roleId);
    }

    @Override
    public List<RolePermission> findOne(int roleId) {
        return rolePermissionDao.findOne(roleId);
    }

    @Override
    public int findOneID(int roleId) {
        return rolePermissionDao.findOneID(roleId);
    }

    @Override
    public int findTotal(int roleId) {
        return rolePermissionDao.findTotal(roleId);
    }

    @Override
    public int deleteById(int id) {
        return rolePermissionDao.deleteById(id);
    }

    @Override
    public int save(RolePermission rolePermission) {
        rolePermission.setCreateDate(new Date());
        return rolePermissionDao.save(rolePermission);
    }

    @Override
    public int update(RolePermission rolePermission) {
        rolePermission.setUpdateDate(new Date());
        return rolePermissionDao.update(rolePermission);
    }

    @Override
    public int deleteMany(List<RolePermission> permissions) {
        return rolePermissionDao.deleteMany(permissions);
    }
}
