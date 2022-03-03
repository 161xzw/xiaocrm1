package com.xiao.crm.service.impl;

import com.xiao.crm.dao.IUserDao;
import com.xiao.crm.domain.User;
import com.xiao.crm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: Candy
 * @date: 2020/11/23 14:49
 * @description: 用户业务实现类
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    /**
     * 查询所有客户
     * @return
     */
    @Override
    public List<User> findAll(int page, int limit) {
        return userDao.findAll(page,limit);
    }

    /**
     * 根据用户名查询指定用户
     * @param user_name
     * @return
     */
    @Override
    public List<User> findOne(String user_name) {
        return userDao.findOne(user_name);
    }

    /**
     * 校检登录
     * @param userName
     * @param userPwd
     * @return
     */
    @Override
    public User checkLogin(String userName,String userPwd){
        return  userDao.checkLogin(userName,userPwd);
    }

    /**
     * 查询用户总数
     * @return
     */
    @Override
    public int findTotal() {
        return userDao.findTotal();
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return userDao.deleteById(id);
    }

    /**
     * 删除多个用户
     * @param users
     * @return
     */
    @Override
    public int deleteMany(List<User> users) {
        return userDao.deleteMany(users);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @Override
    public int save(User user) {
        //设置状态为可用
        user.setIsValid(1);
        //设置创建时间
        user.setCreateDate(new Date());
        return userDao.save(user);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @Override
    public int update(User user) {
        //设置修改时间
        user.setUpdateDate(new Date());
        return userDao.update(user);
    }

    /**
     * 查询用户及其角色
     *
     * @return
     */
    @Override
    public List<User> findUserRole(String userName){
        return userDao.findUserRole(userName);
    }
}
