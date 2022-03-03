package com.xiao.crm.service.impl;

import com.xiao.crm.dao.ICustomerOrderDao;
import com.xiao.crm.domain.CustomerOrder;
import com.xiao.crm.service.ICustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: Candy
 * @date: 2020/12/4 17:05
 * @description:
 */
@Service("customerOrderService")
public class CustomerOrderServiceImpl implements ICustomerOrderService {
    @Autowired
    private ICustomerOrderDao customerOrderDao;
    /**
     * 新增订单
     * @param customerOrder
     * @return
     */
    @Override
    public int save(CustomerOrder customerOrder) {

        // 设置订单编号
//        String uuid = UUID.randomUUID().toString().replace("-","");
//        customerOrder.setOrderNum(uuid);
        //设置状态为可用
        customerOrder.setIsValid(1);
        //设置创建时间
        customerOrder.setCreateDate(new Date());
        return customerOrderDao.save(customerOrder);
    }

    /**
     * 查询六个月内总订单数
     *
     * @return
     */
    @Override
    public int findSixTotal(){
        return customerOrderDao.findSixTotal();
    }

    /**
     * 查询所有订单
     * @return
     */
    @Override
    public List<CustomerOrder> findAll(int page, int limit) {
        return customerOrderDao.findAll(page, limit);
    }

    /**
     * 查询指定订单
     * @return
     */
    @Override
    public List<CustomerOrder> findOne(int cusId) {
        return customerOrderDao.findOne(cusId);
    }

}
