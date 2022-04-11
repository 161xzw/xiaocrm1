package com.xiao.crm.service;

import com.xiao.crm.domain.CusDevPlan;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ICusDevPlanService {
    /**
     * 查询所有客户开发计划
     * @param page
     * @param limit
     * @return
     */
    List<CusDevPlan> findAll(int page, int limit);


    /**
     * 根据客计划内容查询指定客户开发计划
     * @param plan_content
     * @return
     */
    List<CusDevPlan> findOne(String plan_content);

    /**
     * 查询客户开发计划总数
     * @return
     */
    int findTotal();

    /**
     * 根据id删除客户开发计划
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 删除多个客户开发计划
     * @param cusDevPlans
     * @return
     */
    int deleteMany(List<CusDevPlan> cusDevPlans);

    /**
     * 新增客户开发计划
     * @param cusDevPlan
     * @return
     */
    int save(CusDevPlan cusDevPlan);

    /**
     * 修改客户开发计划
     * @param cusDevPlan
     * @return
     */
    int update(CusDevPlan cusDevPlan);
}
