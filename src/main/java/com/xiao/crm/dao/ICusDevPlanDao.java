package com.xiao.crm.dao;

import com.xiao.crm.domain.CusDevPlan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICusDevPlanDao {
    /**
     * 查询所有客户开发计划
     * @return
     */
    @Results(id = "CusDevPlanMap",
            value = {
                    @Result(id = true,property = "id",column = "id"),
                    @Result(property = "saleChanceId",column = "sale_chance_id"),
                    @Result(property = "planContent",column = "plan_content"),
                    @Result(property = "planDate",column = "plan_date"),
                    @Result(property = "exeAffect",column = "exe_affect"),
                    @Result(property = "isValid",column = "is_valid"),
                    @Result(property = "createDate",column = "create_date"),
                    @Result(property = "updateDate",column = "update_date"),
            })
    @Select("select * from cus_dev_plan where is_valid = 1 limit #{page},#{limit}")
    List<CusDevPlan> findAll(@Param("page") int page, @Param("limit") int limit);

    /**
     * 根据客计划查内容询指定客户开发计划
     * @param plan_content
     * @return
     */
    @ResultMap("CusDevPlanMap")
    @Select("select * from cus_dev_plan where is_valid = 1 and plan_content like #{plan_content}")
    List<CusDevPlan> findOne(@Param("plan_content") String plan_content);

    /**
     * 查询客户开发计划总数
     * @return
     */
    @Select("select count(*) from cus_dev_plan where is_valid = 1")
    int findTotal();

    /**
     * 根据id删除客户开发计划
     * @param id
     * @return
     */
    @Update("update cus_dev_plan set is_valid=0 where id=#{id}")
    int deleteById(@Param("id") int id);

    /**
     * 删除多个客户开发计划
     * @param cusDevPlans
     * @return
     */
    @Update({
            "<script>"
                    + "update cus_dev_plan set is_valid =0 where id in "
                    + "<foreach item='item' index='index' collection='cusDevPlans' open='(' separator=',' close=')'>"
                    + "#{item.id}"
                    + "</foreach>"
                    + "</script>"
    })
    int deleteMany(@Param("cusDevPlans") List<CusDevPlan> cusDevPlans);

    /**
     * 新增客户开发计划
     * @param cusDevPlan
     * @return
     */
    @Insert("insert into cus_dev_plan values(#{id},#{saleChanceId},#{planContent},#{planDate}," +
            "#{exeAffect},#{isValid},#{createDate},#{updateDate})")
    @SelectKey(keyColumn = "id",keyProperty = "id",resultType = Integer.class,
            before = false,statement = {"select last_insert_id()"})
    int save(CusDevPlan cusDevPlan);

    /**
     * 修改客户开发计划信息
     *
     * @return
     */
    @Update("update cus_dev_plan set sale_chance_id=#{saleChanceId},plan_content=#{planContent},plan_date=#{planDate}," +
            "exe_affect=#{exeAffect},update_date=#{updateDate} where id=#{id}")
    int update(CusDevPlan cusDevPlan);
}
