package com.xiao.crm.dao;

import com.xiao.crm.domain.SaleChance;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ISaleChanceDao {

    /**
     * 查询所有营销机会
     * @return
     */
    @Results( id = "saleChanceMap",
            value = {
                    @Result(id = true,property = "id",column = "id"),
                    @Result(property = "chanceSource",column = "chance_source"),
                    @Result(property = "customerName",column = "customer_name"),
                    @Result(property = "successProbability",column = "success_probability"),
                    @Result(property = "outline",column = "outline"),
                    @Result(property = "linkMan",column = "link_man"),
                    @Result(property = "linkTel",column = "link_tel"),
                    @Result(property = "details",column = "details"),
                    @Result(property = "createMan",column = "create_man"),
                    @Result(property = "assignMan",column = "assign_man"),
                    @Result(property = "assignTime",column = "assign_time"),
                    @Result(property = "state",column = "state"),
                    @Result(property = "devResult",column = "dev_result"),
                    @Result(property = "isValid",column = "is_valid"),
                    @Result(property = "createDate",column = "create_date"),
                    @Result(property = "updateDate",column = "update_date"),
            })
    @Select("select * from sale_chance where is_valid=1 limit #{page},#{limit}")
    List<SaleChance> findAll(@Param("page") int page, @Param("limit") int limit);

    /**
     * 根据客户名称查询指定营销机会
     * @return
     */
    @ResultMap("saleChanceMap")
    @Select("select * from sale_chance where is_valid = 1 and customer_name like #{customer_name}")
    List<SaleChance> findOne(String customer_name);

    /**
     * 查询总营销数
     * @return
     */
    @Select("select count(*) from sale_chance where is_valid=1")
    int findTotal();

    /**
     * 根据id删除营销机会
     * @return
     */
    @Update("update sale_chance set is_valid=0 where id=#{id}")
    int deleteById(@Param("id") int id);

    /**
     * 删除多个营销机会
     * @return
     */
    @Update({
            "<script>"
                    + "update sale_chance set is_valid =0 where id in "
                    + "<foreach item='item' index='index' collection='saleChances' open='(' separator=',' close=')'>"
                    + "#{item.id}"
                    + "</foreach>"
                    + "</script>"
    })
    int deleteMany(@Param("saleChances") List<SaleChance> saleChances);

    /**
     * 添加营销机会
     * @return
     */
    @Insert("insert into sale_chance values(#{id},#{chanceSource}," +
            "#{customerName},#{successProbability},#{outline},#{linkMan}," +
            "#{linkTel},#{details},#{createMan},#{assignMan},#{assignTime}," +
            "#{state},#{devResult},#{isValid},#{createDate},#{updateDate})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class,
            before = false, statement = {"select last_insert_id()"})
    int save(SaleChance saleChance);

    /**
     * 修改营销机会
     * @param saleChance
     * @return
     */
    @Update("update sale_chance set chance_source=#{chanceSource},customer_name=#{customerName}," +
            "success_probability=#{successProbability}," +
            "outline=#{outline},link_man=#{linkMan},link_tel=#{linkTel},details=#{details}," +
            "create_man=#{createMan},assign_man=#{assignMan},assign_time=#{assignTime}," +
            "state=#{state},dev_result=#{devResult},update_date=#{updateDate} where id=#{id}")
    int update(SaleChance saleChance);
}
