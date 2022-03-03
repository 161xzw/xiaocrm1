package com.xiao.crm.service;

import com.xiao.crm.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Candy
 * @date: 2020/11/23 14:48
 * @description: 用户业务层接口
 */
@Component
public interface IUserService {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll(int page,int limit);

    /**
     * 根据用户名查询指定用户
     * @param user_name
     * @return
     */
    List<User> findOne(String user_name);

    /**
     * 校检登录
     * @param userName
     * @param userPwd
     * @return
     */
    User checkLogin(String userName,String userPwd);

    /**
     * 查询用户总数
     * @return
     */
    int findTotal();

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 删除多个用户
     * @param users
     * @return
     */
    int deleteMany(List<User> users);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 查询用户及其角色
     *
     * @return
     */
    List<User> findUserRole(String userName);
}
