package com.xiao.crm.service;

import com.xiao.crm.domain.CustomerContact;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ICustomerContactService {
    List<CustomerContact> findAllCustomerContact();

    /**
     * 根据客户和联系人查询相关的交往记录
     * @return
     */
    List<CustomerContact> findA(int cusId,int linkManId,int page, int limit);

    /**
     * 根据id删除交往记录
     * @return
     */
    int deleteById(int id);

    /**
     * 删除多个交往记录
     * @return
     */
    int deleteMany(List<CustomerContact> customerContacts);

    /**
     * 查询指定交往记录
     * @return
     */
    List<CustomerContact> findOne(String outline);

    /**
     * 查询总联系人数
     * @return
     */
    int findTotal();

    /**
     * 新增联系人
     * @return
     */
    int save(CustomerContact customerContact);

    /**
     * 修改联系人
     * @return
     */
    int update(CustomerContact customerContact);
}
