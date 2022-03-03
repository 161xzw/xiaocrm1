package com.xiao.crm.service;

import com.xiao.crm.domain.Role;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 角色的业务层层接口
 * @author : Bei-Zhen
 * @date : 2020-12-01 20:08
 */
@Component
public interface IRoleService {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll(int page, int limit);

    /**
     * 查询指定角色
     * @return
     */
    List<Role> findOne(String name);

    /**
     * 查询总角色数
     * @return
     */
    int findTotal();

    /**
     * 根据id删除角色
     * @return
     */
    int deleteById(int id);

    /**
     * 新增角色
     * @return
     */
    int save(Role role);

    /**
     * 修改角色
     * @return
     */
    int update(Role role);

    /**
     * 删除多个角色
     * @return
     */
    int deleteMany(List<Role> roles);
}
