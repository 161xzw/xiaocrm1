package com.xiao.crm.service.impl;

import com.xiao.crm.dao.IRoleDao;
import com.xiao.crm.domain.Role;
import com.xiao.crm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    /**
     * 查询所有角色
     * @return
     */
    @Override
    public List<Role> findAll(int page, int limit) {
        return roleDao.findAll(page, limit);
    }

    /**
     * 查询指定角色
     * @return
     */
    @Override
    public List<Role> findOne(String name) {
        return roleDao.findOne(name);
    }

    @Override
    public List<Role> findOneByID(int id) {
        return roleDao.findOneByID(id);
    }

    /**
     * 查询总角色数
     * @return
     */
    @Override
    public int findTotal() {
        return roleDao.findTotal();
    }

    /**
     * 根据id删除角色
     * @return
     */
    @Override
    public int deleteById(int id) {
        return roleDao.deleteById(id);
    }

    /**
     * 新增角色
     * @return
     */
    @Override
    public int save(Role role) {
        //设置状态为可用
        role.setIsValid(1);
        //设置创建时间
        role.setCreateDate(new Date());
        return roleDao.save(role);
    }

    /**
     * 修改角色
     * @return
     */
    @Override
    public int update(Role role) {
        //设置修改时间
        role.setUpdateDate(new Date());
        return roleDao.update(role);
    }

    /**
     * 删除多个角色
     * @return
     */
    @Override
    public int deleteMany(List<Role> roles) {
        return roleDao.deleteMany(roles);
    }
}
