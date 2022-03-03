package com.xiao.crm.service;

import com.xiao.crm.domain.RolePermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Bei-Zhen
 * @date : 2020-12-06 2:47
 */
@Component
public interface IRolePermissionService {

    /**
     * 查询所有角色权限
     *
     * @return
     */
    List<RolePermission> findAll(@Param("page") int page, @Param("limit") int limit, int roleId);

    /**
     * 查询指定角色权限
     *
     * @return
     */
    List<RolePermission> findOne(@Param("roleId") int roleId);

    /**
     * 查询总角色权限数
     *
     * @return
     */
    int findTotal(int roleId);

    /**
     * 根据id删除角色权限
     *
     * @return
     */
    int deleteById(@Param("id") int id);

    /**
     * 添加角色权限
     *
     * @return
     */
    int save(RolePermission rolePermission);

    /**
     * 修改角色权限信息
     *
     * @return
     */
    int update(RolePermission rolePermission);

    /**
     * 删除多个角色权限
     *
     * @return
     */
    int deleteMany(@Param("permissions") List<RolePermission> permissions);
}
