package com.xiao.crm.service;

import com.xiao.crm.domain.Permission;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 权限的业务层层接口
 * @author : Bei-Zhen
 * @date : 2020-12-01 20:09
 */
@Component
public interface IPermissionService {

    /**
     * 查询所有权限
     * @return
     */
    List<Permission> findAll(int page, int limit);

    /**
     * 查询指定权限
     * @return
     */
    List<Permission> findOne(String name);

    /**
     * 查询总权限数
     * @return
     */
    int findTotal();

    /**
     * 根据id删除权限
     * @return
     */
    int deleteById(int id);

    /**
     * 新增权限
     * @return
     */
    int save(Permission permission);

    /**
     * 修改权限
     * @return
     */
    int update(Permission permission);

    /**
     * 删除多个权限
     * @return
     */
    int deleteMany(List<Permission> permissions);
}
