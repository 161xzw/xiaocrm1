package com.xiao.crm.service.impl;

import com.xiao.crm.dao.IPermissionDao;
import com.xiao.crm.domain.Permission;
import com.xiao.crm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 权限的业务层实现类
 * @author : Bei-Zhen
 * @date : 2020-12-01 20:10
 */
@Service("permissionService")
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    /**
     * 查询所有权限
     * @return
     */
    @Override
    public List<Permission> findAll(int page, int limit) {
        return permissionDao.findAll(page, limit);
    }

    /**
     * 查询指定角色
     * @return
     */
    @Override
    public List<Permission> findOne(String name) {
        return permissionDao.findOne(name);
    }

    /**
     * 查询总权限数
     * @return
     */
    @Override
    public int findTotal() {
        return permissionDao.findTotal();
    }

    /**
     * 根据id删除权限
     * @return
     */
    @Override
    public int deleteById(int id) {
        return permissionDao.deleteById(id);
    }

    /**
     * 新增权限
     * @return
     */
    @Override
    public int save(Permission permission) {
        //设置状态为可用
        permission.setIsValid(1);
        //设置创建时间
        permission.setCreateDate(new Date());
        return permissionDao.save(permission);
    }

    /**
     * 修改权限
     * @return
     */
    @Override
    public int update(Permission permission) {
        //设置修改时间
        permission.setUpdateDate(new Date());
        return permissionDao.update(permission);
    }

    /**
     * 删除多个权限
     * @return
     */
    @Override
    public int deleteMany(List<Permission> permissions) {
        return permissionDao.deleteMany(permissions);
    }
}
