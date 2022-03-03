package com.xiao.crm.service;

import com.xiao.crm.domain.CustomerLinkMan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ICustomerLinkManService {
    List<CustomerLinkMan> findAllCustomerLinkMan();

    /**
     * 查询相关联系人
     * @return
     */
    List<CustomerLinkMan> findA(int cusId,int page, int limit);

    /**
     * 根据id删除联系人
     * @return
     */
    int deleteById(int id);

    /**
     * 删除多个联系人
     * @return
     */
    int deleteMany(List<CustomerLinkMan> customerLinkMan);

    /**
     * 查询指定联系人
     * @return
     */
    List<CustomerLinkMan> findOne(String name);

    /**
     * 查询总联系人数
     * @return
     */
    int findTotal();

    /**
     * 新增联系人
     * @return
     */
    int save(CustomerLinkMan customerLinkMan);

    /**
     * 修改联系人
     * @return
     */
    int update(CustomerLinkMan customerLinkMan);

    /**
     * 查询六个月内联系人数
     *
     * @return
     */
    int findSixTotal();
}
