package com.xiao.crm.service.impl;

import com.xiao.crm.dao.ICustomerDao;
import com.xiao.crm.dao.ICustomerLossDao;
import com.xiao.crm.domain.CustomerLoss;
import com.xiao.crm.service.ICustomerLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("customerLossService")
public class CustomerLossServiceImpl implements ICustomerLossService {
    @Autowired
    private ICustomerLossDao customerLossDao;
    @Autowired
    private ICustomerDao customerDao;

    @Override
    public List<CustomerLoss> findAll(int page, int limit) {
        return customerLossDao.findAll();
    }

    @Override
    public List<CustomerLoss> findOne(String cusName) {

        return customerLossDao.findOne(cusName);
    }

    @Override
    public int findTotal() {
        return customerLossDao.findTotal();
    }

    @Override
    public int deleteById(int id) {
        return customerLossDao.deleteById(id);
    }

    @Override
    public int save(CustomerLoss customerLoss) {
        customerLoss.setState(1);
        customerLoss.setIsValid(1);
        //设置创建时间
        customerLoss.setCreateTime(new Date());
//        设置最后流失时间
        customerLoss.setConfirmLossTime(new Date());
        System.out.println("添加流失客户："+customerLoss);
        return customerLossDao.save(customerLoss);
    }

    @Override
    public int update(CustomerLoss customerLoss) {
//        customerLoss.setState(1);
//        customerLoss.setIsValid(1);
        customerLoss.setUpdateTime(new Date());
        System.out.println("编辑流失客户:"+customerLoss);
        return customerLossDao.update(customerLoss);
    }

    @Override
    public int deleteMany(List<CustomerLoss> customerLosses) {
        return customerLossDao.deleteMany(customerLosses);
    }

    /**
     * 查询六个月内总客户流失数
     *
     * @return
     */
    @Override
    public int findSixTotal(){
        return customerLossDao.findSixTotal();
    }
}
