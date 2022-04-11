package com.xiao.crm.service.impl;

import com.xiao.crm.dao.ISaleChanceDao;
import com.xiao.crm.domain.SaleChance;
import com.xiao.crm.service.ISaleChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("saleChanceService")
public class SaleChanceServiceImpl implements ISaleChanceService {

    @Autowired
    private ISaleChanceDao saleChanceDao;

    /**
     * 查询所有营销机会
     * @return
     */
    @Override
    public List<SaleChance> findAll(int page, int limit) {
        return saleChanceDao.findAll(page, limit);
    }

    /**
     * 根据客户名称查询指定营销机会
     * @return
     */
    @Override
    public List<SaleChance> findOne(String customer_name) {
        return saleChanceDao.findOne(customer_name);
    }

    /**
     * 查询总营销数
     * @return
     */
    @Override
    public int findTotal() {
        return saleChanceDao.findTotal();
    }

    /**
     * 根据id删除营销机会
     * @return
     */
    @Override
    public int deleteById(int id) {
        return saleChanceDao.deleteById(id);
    }

    /**
     * 删除多个营销机会
     * @return
     */
    @Override
    public int deleteMany(List<SaleChance> saleChances) {
        return saleChanceDao.deleteMany(saleChances);
    }

    /**
     * 新增营销机会
     * @param saleChance
     * @return
     */
    @Override
    public int save(SaleChance saleChance) {
        //设置状态为可用
        saleChance.setIsValid(1);
        //saleChance.setState(1);
        //设置创建时间
        saleChance.setCreateDate(new Date());
        return saleChanceDao.save(saleChance);
    }

    /**
     * 修改营销机会
     * @param saleChance
     * @return
     */
    @Override
    public int update(SaleChance saleChance) {
        //设置修改时间
        saleChance.setUpdateDate(new Date());
        return saleChanceDao.update(saleChance);
    }
}
