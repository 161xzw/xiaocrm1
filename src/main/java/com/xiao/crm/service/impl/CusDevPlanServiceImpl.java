package com.xiao.crm.service.impl;

import com.xiao.crm.dao.ICusDevPlanDao;
import com.xiao.crm.domain.CusDevPlan;
import com.xiao.crm.service.ICusDevPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: Candy
 * @date: 2020/12/1 22:08
 * @description: 客户开发计划的业务层实现类
 */
@Service("cusDevPlanService")
public class CusDevPlanServiceImpl implements ICusDevPlanService {
    @Autowired
    public ICusDevPlanDao cusDevPlanDao;
    /**
     * 查询所有客户开发计划
     * @return
     */
    @Override
    public List<CusDevPlan> findAll(int page, int limit) {
        return cusDevPlanDao.findAll(page,limit);
    }

    /**
     * 根据计划内容查询指定客户开发计划
     * @param cusDevPlan_name
     * @return
     */
    @Override
    public List<CusDevPlan> findOne(String cusDevPlan_name) {
        return cusDevPlanDao.findOne(cusDevPlan_name);
    }


    /**
     * 查询客户开发计划总数
     * @return
     */
    @Override
    public int findTotal() {
        return cusDevPlanDao.findTotal();
    }

    /**
     * 根据id删除客户开发计划
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return cusDevPlanDao.deleteById(id);
    }

    /**
     * 删除多个客户开发计划
     * @param cusDevPlans
     * @return
     */
    @Override
    public int deleteMany(List<CusDevPlan> cusDevPlans) {
        return cusDevPlanDao.deleteMany(cusDevPlans);
    }

    /**
     * 新增客户开发计划
     * @param cusDevPlan
     * @return
     */
    @Override
    public int save(CusDevPlan cusDevPlan) {
        //设置状态为可用
        cusDevPlan.setIsValid(1);
        //设置创建时间
        cusDevPlan.setCreateDate(new Date());
        System.out.println("实现层");
        return cusDevPlanDao.save(cusDevPlan);
    }

    /**
     * 修改客户开发计划
     * @param cusDevPlan
     * @return
     */
    @Override
    public int update(CusDevPlan cusDevPlan) {
        //设置修改时间
        cusDevPlan.setUpdateDate(new Date());
        return cusDevPlanDao.update(cusDevPlan);
    }
}
