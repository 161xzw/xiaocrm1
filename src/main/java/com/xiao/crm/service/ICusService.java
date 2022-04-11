package com.xiao.crm.service;

import com.xiao.crm.domain.CusService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ICusService {

    /**
     * 查询所有客户服务
     * @param page
     * @param limit
     * @return
     */
    List<CusService> findAll(int page,int limit);

    /**
     * 根据服务要求查询指定客户服务
     * @param request
     * @return
     */
    List<CusService> findOne(String request);

    /**
     * 查询客户服务总数
     * @return
     */
    int findTotal();

    /**
     * 根据id删除客户服务
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 删除多个客户服务
     * @param cusServices
     * @return
     */
    int deleteMany(List<CusService> cusServices);

    /**
     * 新增客户服务
     * @param cusService
     * @return
     */
    int save(CusService cusService);

    /**
     * 修改客户服务
     * @param cusService
     * @return
     */
    int update(CusService cusService);
    
}
