package com.xiao.crm.service.impl;

import com.xiao.crm.dao.ICustomerLinkManDao;
import com.xiao.crm.domain.CustomerLinkMan;
import com.xiao.crm.service.ICustomerLinkManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("customerLinkManService")
public class CustomerLinkManServiceImpl implements ICustomerLinkManService {

    @Autowired
    public ICustomerLinkManDao customerLinkManDao;

    public List<CustomerLinkMan> findAllCustomerLinkMan() {
        System.out.println("查询所有联系人信息：");
        return customerLinkManDao.findAll();
    }

    @Override
    public List<CustomerLinkMan> findA(int cusId,int page, int limit) {
        System.out.println("查询相关联系人");
        return customerLinkManDao.findA(cusId,page,limit);
    }

    @Override
    public int deleteById(int id) {
        return customerLinkManDao.deleteById(id);
    }

    @Override
    public int deleteMany(List<CustomerLinkMan> customerLinkMan) {
        return customerLinkManDao.deleteMany(customerLinkMan);
    }

    @Override
    public List<CustomerLinkMan> findOne(String name) {
        return customerLinkManDao.findOne(name);
    }

    @Override
    public int findTotal() {
        return customerLinkManDao.findTotal();
    }

    @Override
    public int save(CustomerLinkMan customerLinkMan) {
        customerLinkMan.setIsValid(1);
        //设置创建时间
        customerLinkMan.setCreateDate(new Date());
        return customerLinkManDao.save(customerLinkMan);
    }

    @Override
    public int update(CustomerLinkMan customerLinkMan) {
        //设置修改时间
        customerLinkMan.setUpdateDate(new Date());
        System.out.println("修改联系人信息："+customerLinkMan);
        return customerLinkManDao.update(customerLinkMan);
    }

    /**
     * 查询六个月内总联系人数
     *
     * @return
     */
    @Override
    public int findSixTotal(){
        return customerLinkManDao.findSixTotal();
    }
}
