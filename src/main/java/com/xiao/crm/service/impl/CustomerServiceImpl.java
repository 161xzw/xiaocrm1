package com.xiao.crm.service.impl;

import com.xiao.crm.dao.ICustomerDao;
import com.xiao.crm.domain.Customer;
import com.xiao.crm.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 客户的业务层实现类
 * @author : Bei-Zhen
 * @date : 2020-11-23 14:26
 */
@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao customerDao;

    /**
     * 查询所有客户
     * @return
     */
    @Override
    public List<Customer> findAll(int page, int limit) {
        return customerDao.findAll(page, limit);
    }

    /**
     * 查询指定客户
     * @return
     */
    @Override
    public List<Customer> findOne(String name) {
        return customerDao.findOne(name);
    }

    /**
     * 查询总客户数
     * @return
     */
    @Override
    public int findTotal() {
        return customerDao.findTotal();
    }

    /**
     * 根据id删除客户
     * @return
     */
    @Override
    public int deleteById(int id) {
        return customerDao.deleteById(id);
    }

    /**
     * 新增客户
     * @return
     */
    @Override
    public int save(Customer customer) {
        //设置状态为可用
        customer.setIsValid(1);
        //设置创建时间
        customer.setCreateDate(new Date());
        return customerDao.save(customer);
    }

    /**
     * 修改客户
     * @return
     */
    @Override
    public int update(Customer customer) {
        //设置修改时间
        customer.setUpdateDate(new Date());
        return customerDao.update(customer);
    }

    /**
     * 删除多个客户
     * @return
     */
    @Override
    public int deleteMany(List<Customer> customers) {
        return customerDao.deleteMany(customers);
    }

    @Override
    public int loss(int id) {
        return customerDao.loss(id);
    }

    /**
     * 查询一个月内总客户数
     *
     * @return
     */
    @Override
    public int findOneTotal(){
        return customerDao.findOneTotal();
    }

    /**
     * 查询两个月内总客户数
     *
     * @return
     */
    @Override
    public int findTwoTotal(){
        return customerDao.findTwoTotal();
    }

    /**
     * 查询三个月内总客户数
     *
     * @return
     */
    @Override
    public int findThreeTotal(){
        return customerDao.findThreeTotal();
    }

    /**
     * 查询四个月内总客户数
     *
     * @return
     */
    @Override
    public int findFourTotal(){
        return customerDao.findFourTotal();
    }

    /**
     * 查询五个月内总客户数
     *
     * @return
     */
    @Override
    public int findFiveTotal(){
        return customerDao.findFiveTotal();
    }

    /**
     * 查询六个月内总客户数
     *
     * @return
     */
    @Override
    public int findSixTotal(){
        return customerDao.findSixTotal();
    }

}
