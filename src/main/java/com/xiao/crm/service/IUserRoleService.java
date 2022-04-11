package com.xiao.crm.service;

import com.xiao.crm.domain.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface IUserRoleService {

    /**
     * 查询所有用户角色
     *
     * @return
     */
    List<UserRole> findAll(@Param("page") int page, @Param("limit") int limit, int userId);

    /**
     * 查询指定用户角色
     *
     * @return
     */
    List<UserRole> findOne(@Param("userId") int userId);

    int  findroleID(@Param("userId") int userId);

    /**
     * 查询总用户角色数
     *
     * @return
     */
    int findTotal(int userId);

    /**
     * 根据id删除用户角色
     *
     * @return
     */
    int deleteById(@Param("id") int id);

    /**
     * 添加用户角色
     *
     * @return
     */
    int save(UserRole userRole);

    /**
     * 修改用户角色信息
     *
     * @return
     */
    int update(UserRole userRole);

    /**
     * 删除多个用户角色
     *
     * @return
     */
    int deleteMany(@Param("userRoles") List<UserRole> userRoles);
}
