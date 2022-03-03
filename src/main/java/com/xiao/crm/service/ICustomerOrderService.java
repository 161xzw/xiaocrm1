package com.xiao.crm.service;

import com.xiao.crm.domain.CustomerOrder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Candy
 * @date: 2020/12/4 17:04
 * @description:
 */
@Component
public interface ICustomerOrderService {
    /**
     * 新增订单
     * @param customerOrder
     * @return
     */
    int save(CustomerOrder customerOrder);

    /**
     * 查询六个月内总订单数
     *
     * @return
     */
    int findSixTotal();

    /**
     * 查询所有订单
     * @return
     */
    List<CustomerOrder> findAll(int page, int limit);

    /**
     * 查询指定订单
     * @return
     */
    List<CustomerOrder> findOne(int cusId);
}
