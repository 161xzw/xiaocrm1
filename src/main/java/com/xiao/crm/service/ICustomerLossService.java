package com.xiao.crm.service;

import com.xiao.crm.domain.CustomerLoss;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ICustomerLossService {
    /**
     * 查询所有流失客户
     * @return
     */
    List<CustomerLoss> findAll(int page, int limit);

    /**
     * 查询指定流失客户
     * @return
     */
    List<CustomerLoss> findOne(String cusName);

    /**
     * 查询总流失客户数
     * @return
     */
    int findTotal();

    /**
     * 根据id删除流失客户
     * @return
     */
    int deleteById(int id);

    /**
     * 新增流失客户
     * @return
     */
    int save(CustomerLoss customerLoss);

    /**
     * 修改流失客户
     * @return
     */
    int update(CustomerLoss customerLoss);

    /**
     * 删除多个流失客户
     * @return
     */
    int deleteMany(List<CustomerLoss> customerLosses);

    /**
     * 查询六个月内总流失客户数
     *
     * @return
     */
    int findSixTotal();
}
