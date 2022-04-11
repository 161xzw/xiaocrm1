package com.xiao.crm.service.impl;

import com.xiao.crm.dao.IUserRoleDao;
import com.xiao.crm.domain.UserRole;
import com.xiao.crm.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    private IUserRoleDao userRoleDao;

    @Override
    public List<UserRole> findAll(int page, int limit,int userId) {
        return userRoleDao.findAll(page,limit,userId);
    }

    @Override
    public List<UserRole> findOne(int userId) {
        return userRoleDao.findOne(userId);
    }

    @Override
    public int findroleID(int userId) {
        return userRoleDao.findroleID(userId);
    }

    @Override
    public int findTotal(int userId) {
        return userRoleDao.findTotal(userId);
    }

    @Override
    public int deleteById(int id) {
        return userRoleDao.deleteById(id);
    }

    @Override
    public int save(UserRole userRole) {
        userRole.setCreateDate(new Date());
        return userRoleDao.save(userRole);
    }

    @Override
    public int update(UserRole userRole) {
        userRole.setUpdateDate(new Date());
        return userRoleDao.update(userRole);
    }

    @Override
    public int deleteMany(List<UserRole> userRoles) {
        return userRoleDao.deleteMany(userRoles);
    }
}
