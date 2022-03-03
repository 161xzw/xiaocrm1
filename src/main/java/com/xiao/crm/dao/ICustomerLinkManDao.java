package com.xiao.crm.dao;

import com.xiao.crm.domain.CustomerLinkMan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerLinkManDao {
    /*
    查询所有联系人
     */
    @Results(id = "customerLinkManMap",
            value = {
            //实体类property，数据库列column
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "cusId",column = "cus_id"),
            @Result(property = "linkMan",column = "link_man"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "position",column = "position"),
            @Result(property = "tel",column = "tel"),
            @Result(property = "isValid",column = "is_valid"),
            @Result(property = "createDate",column = "create_date"),
            @Result(property = "updateDate",column = "update_date")
    })
    @Select("select *from customer_link_man where is_valid=1")
    public List<CustomerLinkMan> findAll();

    /**
    *根据客户id查找相关联系人
     * @return
     */
    @ResultMap("customerLinkManMap")
    @Select("select *from customer_link_man where is_valid=1 and cus_id=#{cusId} limit #{page},#{limit}")
    List<CustomerLinkMan> findA(@Param("cusId") int cusId, @Param("page") int page, @Param("limit") int limit);

    /**
     * 根据id删除联系人
     * @return
     */
    @Update("update customer_link_man set is_valid=0 where id=#{id}")
    int deleteById(@Param("id") int id);

    /**
     * 删除多个联系人
     * @return
     */
    @Update({
            "<script>"
                    + "update customer_link_man set is_valid =0 where id in "
                    + "<foreach item='item' index='index' collection='customerLinkMan' open='(' separator=',' close=')'>"
                    + "#{item.id}"
                    + "</foreach>"
                    + "</script>"
    })
    int deleteMany(@Param("customerLinkMan") List<CustomerLinkMan> customerLinkMan);

    /**
     * 查询指定联系人
     *
     * @return
     */
    @ResultMap("customerLinkManMap")
    @Select("select * from customer_link_man where is_valid=1 and link_man like #{linkMan}")
    List<CustomerLinkMan> findOne(@Param("linkMan") String linkMan);

    /**
     * 查询总联系人数
     *
     * @return
     */
    @Select("select count(*) from customer_link_man where is_valid=1")
    int findTotal();

    /**
     * 添加联系人
     * @return
     */
    @Insert("insert into customer_link_man values(#{id},#{cusId},#{linkMan},#{sex},#{position},#{tel},"
            +"#{isValid},#{createDate},#{updateDate})")
    @SelectKey(keyColumn = "id",keyProperty = "id",resultType = Integer.class,
            before = false,statement = {"select last_insert_id()"})
    int save(CustomerLinkMan customerLinkMan);

    /**
     * 修改联系人信息
     * @return
     */
    @Update("update customer_link_man set cus_id=#{cusId},link_man=#{linkMan},sex=#{sex}," +
            "position=#{position},tel=#{tel},update_date=#{updateDate} where id=#{id}")
    int update(CustomerLinkMan customerLinkMan);

    /**
     * 查询六个月内新增联系人数量
     *
     * @return
     */
    @Select("select count(*) FROM customer_link_man where create_date between date_sub(now(),interval 6 month) and now()")
    int findSixTotal();
}
