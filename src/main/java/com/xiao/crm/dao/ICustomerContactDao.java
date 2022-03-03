package com.xiao.crm.dao;

import com.xiao.crm.domain.CustomerContact;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerContactDao {
    /**
    查询所有交往记录
     */
    @Results(id = "CustomerContactMap",
            value = {
            //实体类property，数据库列column
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "cusId",column = "cus_id"),
            @Result(property = "linkManId",column = "link_man_id"),
            @Result(property = "contactTime", column = "contact_time"),
            @Result(property = "address",column = "address"),
            @Result(property = "outline",column = "outline"),
            @Result(property = "isValid",column = "is_valid"),
            @Result(property = "createDate",column = "create_date"),
            @Result(property = "updateDate",column = "update_date"),

    })
    @Select("select *from customer_contact where is_valid=1")
    public List<CustomerContact> findAll();

    /**
     *根据客户id(cusId)和联系人id(linkManId)查找交往记录
     * @return
     */
    @ResultMap("CustomerContactMap")
    @Select("select *from customer_contact where is_valid=1 and cus_id=#{cusId} and link_man_id=#{linkManId} limit #{page},#{limit}")
    List<CustomerContact> findA(@Param("cusId") int cusId, @Param("linkManId") int linkManId, @Param("page") int page, @Param("limit") int limit);

    /**
     * 根据id删除交往记录
     * @return
     */
    @Update("update customer_contact set is_valid=0 where id=#{id}")
    int deleteById(@Param("id") int id);

    /**
     * 删除多个交往记录
     * @return
     */
    @Update({
            "<script>"
                    + "update customer_contact set is_valid =0 where id in "
                    + "<foreach item='item' index='index' collection='customerContacts' open='(' separator=',' close=')'>"
                    + "#{item.id}"
                    + "</foreach>"
                    + "</script>"
    })
    int deleteMany(@Param("customerContacts") List<CustomerContact> customerContacts);

    /**
     * 查询指定交往记录
     * @return
     */
    @ResultMap("CustomerContactMap")
    @Select("select * from customer_contact where is_valid=1 and outline like #{outline}")
    List<CustomerContact> findOne(@Param("outline") String outline);

    /**
     * 查询交往记录总数
     * @return
     */
    @Select("select count(*) from customer_contact where is_valid=1")
    int findTotal();

    /**
     * 添加交往记录
     * @return
     */
    @Insert("insert into customer_contact values(#{id},#{cusId},#{linkManId},#{contactTime},#{address},#{outline},"
            +"#{isValid},#{createDate},#{updateDate})")
    @SelectKey(keyColumn = "id",keyProperty = "id",resultType = Integer.class,
            before = false,statement = {"select last_insert_id()"})
    int save(CustomerContact customerContact);

    /**
     * 修改交往记录信息
     * @return
     * cus_id=#{cusId},link_man_id=#{linkManId},
     */
    @Update("update customer_contact set contact_time=#{contactTime},address=#{address},outline=#{outline},"+
            "update_date=#{updateDate} where id=#{id}")
    int update(CustomerContact customerContact);
}
