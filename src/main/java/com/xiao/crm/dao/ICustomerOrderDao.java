package com.xiao.crm.dao;

import com.xiao.crm.domain.CustomerOrder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICustomerOrderDao {
    /**
     * 新增订单
     * @param customerOrder
     * @return
     */
    @Insert("insert into customer_order values (#{id},#{cusId},#{orderNum},#{orderDate}," +
            "#{address},#{money},#{isValid},#{createDate},#{updateDate})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class,
            before = false, statement = {"select last_insert_id()"})
    int save(CustomerOrder customerOrder);

    /**
     * 查询六个月内新增订单数
     *
     * @return
     */
    @Select("select count(*) FROM customer_order where create_date between date_sub(now(),interval 6 month) and now()")
    int findSixTotal();

    /**
     * 查询所有订单
     */
    @Results(id="customerOrderMap",
            value = {
                    //实体类property，数据库列column
                    @Result(id = true,property = "id",column = "id"),
                    @Result(property = "cusId",column = "cus_id"),
                    @Result(property = "orderNum",column = "order_num"),
                    @Result(property = "orderDate",column = "order_date"),
                    @Result(property = "address",column = "address"),
                    @Result(property = "money",column = "money"),
                    @Result(property = "isValid",column = "is_valid"),
                    @Result(property = "createDate",column = "create_date"),
                    @Result(property = "createDate",column = "update_date")
            })
    @Select("select *from customer_order where is_valid=1 limit #{page},#{limit}")
    List<CustomerOrder> findAll(@Param("page") int page, @Param("limit") int limit);

    /**
     * 查询指定客户订单
     *
     * @return
     */
    @ResultMap("customerOrderMap")
    @Select("select * from customer_order where is_valid=1 and cus_id=#{cusId}")
    List<CustomerOrder> findOne(@Param("cusId") int cusId);
}
