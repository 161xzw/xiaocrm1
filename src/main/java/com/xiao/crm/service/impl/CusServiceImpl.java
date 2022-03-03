package com.xiao.crm.service.impl;

import com.xiao.crm.dao.ICusServiceDao;
import com.xiao.crm.domain.CusService;
import com.xiao.crm.service.ICusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: Candy
 * @date: 2020/12/3 15:39
 * @description:
 */
@Service("cusService")
public class CusServiceImpl implements ICusService {
    @Autowired
    private ICusServiceDao cusServiceDao;

    /**
     * 查询所有客户服务
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<CusService> findAll(int page, int limit) {
        return cusServiceDao.findAll(page,limit);
    }

    /**
     * 根据客户名查询指定客户服务
     * @param request
     * @return
     */
    @Override
    public List<CusService> findOne(String request) {
        return cusServiceDao.findOne(request);
    }

    /**
     * 查询客户服务总数
     * @return
     */
    @Override
    public int findTotal() {
        return cusServiceDao.findTotal();
    }

    /**
     * 根据id删除客户服务
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return cusServiceDao.deleteById(id);
    }

    /**
     * 删除多个客户服务
     * @param cusServices
     * @return
     */
    @Override
    public int deleteMany(List<CusService> cusServices) {
        return cusServiceDao.deleteMany(cusServices);
    }

    /**
     * 新增客户服务
     * @param cusService
     * @return
     */
    @Override
    public int save(CusService cusService) {
        //设置状态为可用
        cusService.setIsValid(1);
        //设置创建时间
        cusService.setCreateDate(new Date());
        return cusServiceDao.save(cusService);
    }

    /**
     * 修改客户服务
     * @param cusService
     * @return
     */
    @Override
    public int update(CusService cusService) {
        //设置修改时间
        cusService.setUpdateDate(new Date());
        return cusServiceDao.update(cusService);
    }
}
