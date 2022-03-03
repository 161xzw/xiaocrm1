package com.xiao.crm.dao;

import com.xiao.crm.domain.CustomerLoss;
import com.xiao.crm.domain.CustomerLoss;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerLossDao {
    /**
     * 查询所有流失客户:仅查询有效流失客户
     */
    @Results(id="customerLossMap",
        value = {
                //实体类property，数据库列column
                @Result(id = true,property = "id",column = "id"),
                @Result(property = "cusId",column = "cus_id"),
                @Result(property = "cusName",column = "cus_name"),
                @Result(property = "cusManger",column = "cus_manger"),
                @Result(property = "lastOrderTime",column = "last_order_time"),
                @Result(property = "confirmLossTime",column = "confirm_loss_time"),
                @Result(property = "state",column = "state"),
                @Result(property = "lossReason",column = "loss_reason"),
                @Result(property = "isValid",column = "is_valid"),
                @Result(property = "createTime",column = "create_time"),
                @Result(property = "updateTime",column = "update_time")
        })
    @Select("select *from customer_loss where is_valid=1")
    public List<CustomerLoss> findAll();

//    /**
//     *查找流失客户
//     * @return
//     */
//    @ResultMap("customerLossMap")
//    @Select("select *from customer_loss where state=1 limit #{page},#{limit}")
//    List<CustomerLinkMan> findA(@Param("cusId") int cusId, @Param("page") int page, @Param("limit") int limit);

    /**
     * 根据id删除流失客户：仅删除，为修改为未流失状态客户
     * @return
     */
    @Update("update customer_loss set is_valid=0 where id=#{id}")
    int deleteById(@Param("id") int id);

    /**
     * 删除多个流失客户
     * @return
     */
    @Update({
            "<script>"
                    + "update customer_loss set is_valid =0 where id in "
                    + "<foreach item='item' index='index' collection='customerLosses' open='(' separator=',' close=')'>"
                    + "#{item.id}"
                    + "</foreach>"
                    + "</script>"
    })
    int deleteMany(@Param("customerLosses") List<CustomerLoss> customerLosses);

    /**
     * 查询指定流失客户
     *
     * @return
     */
    @ResultMap("customerLossMap")
    @Select("select * from customer_loss where is_valid=1 and cus_name like #{cusName}")
    List<CustomerLoss> findOne(@Param("cusName") String cusName);

    /**
     * 查询总流失客户数
     *
     * @return
     */
    @Select("select count(*) from customer_loss where is_valid=1")
    int findTotal();

    /**
     * 添加流失客户
     * @return
     */
    @Insert("insert into customer_loss values(#{id},#{cusId},#{cusName},#{cusManger},#{lastOrderTime},#{confirmLossTime},"
            +"#{state},#{lossReason},#{isValid},#{createTime},#{updateTime})")
    @SelectKey(keyColumn = "id",keyProperty = "id",resultType = Integer.class,
            before = false,statement = {"select last_insert_id()"})
    int save(CustomerLoss customerLoss);

    /**
     * 修改流失客户信息:只能修改最后下单时间和流失原因
     * @return
     */
    @Update("update customer_loss set last_order_time=#{lastOrderTime},loss_reason=#{lossReason},update_time=#{updateTime} where id=#{id}")
    int update(CustomerLoss customerLoss);

    /**
     * 查询六个月内总客户流失数
     *
     * @return
     */
    @Select("select count(*) FROM customer_loss where create_time between date_sub(now(),interval 6 month) and now()")
    int findSixTotal();

}
