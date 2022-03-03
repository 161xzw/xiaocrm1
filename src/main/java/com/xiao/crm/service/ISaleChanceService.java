package com.xiao.crm.service;

import com.xiao.crm.domain.SaleChance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Candy
 * @date: 2020/12/01 15:03
 * @description: 营销机会的业务层层接口
 */
@Component
public interface ISaleChanceService {

    /**
     * 查询所营销机会
     * @return
     */
    List<SaleChance> findAll(int page, int limit);


    /**
     * 根据客户名称查询指定营销机会
     * @return
     */
    List<SaleChance> findOne(String customer_name);

    /**
     * 查询总营销数
     * @return
     */
    int findTotal();

    /**
     * 根据id删除营销机会
     * @return
     */
    int deleteById(int id);

    /**
     * 删除多个营销机会
     * @return
     */
    int deleteMany(List<SaleChance> saleChances);

    /**
     * 新增营销机会
     * @param saleChance
     * @return
     */
     int save(SaleChance saleChance);

    /**
     * 修改营销机会
     * @param saleChance
     * @return
     */
    int update(SaleChance saleChance);
}
