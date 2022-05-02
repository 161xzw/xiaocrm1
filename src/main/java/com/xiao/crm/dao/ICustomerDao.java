package com.xiao.crm.dao;

import com.xiao.crm.domain.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICustomerDao {

    /**
     * 查询所有客户数
     *
     * @return
     */
    @Results(id = "customerMap",
            value = {
                    @Result(id = true, property = "id", column = "id"),
                    @Result(property = "name", column = "name"),
                    @Result(property = "area", column = "area"),
                    @Result(property = "cusManager", column = "cus_manager"),
                    @Result(property = "level", column = "level"),
                    @Result(property = "satisfaction", column = "satisfaction"),
                    @Result(property = "creditLine", column = "credit_line"),
                    @Result(property = "address", column = "address"),
                    @Result(property = "postCode", column = "post_code"),
                    @Result(property = "tel", column = "tel"),
                    @Result(property = "webSite", column = "web_site"),
                    @Result(property = "regCaptial", column = "reg_captial"),
                    @Result(property = "depBank", column = "dep_bank"),
                    @Result(property = "depAccount", column = "dep_account"),
                    @Result(property = "yearlyTurnover", column = "yearly_turnover"),
                    @Result(property = "state", column = "state"),
                    @Result(property = "isValid", column = "is_valid"),
                    @Result(property = "createDate", column = "create_date"),
                    @Result(property = "updateDate", column = "update_date"),
            })
    @Select("select * from customer where is_valid=1 limit #{page},#{limit}")
    List<Customer> findAll(@Param("page") int page, @Param("limit") int limit);

    @Select("select * from customer where is_valid=1 and satisfaction='企业'  limit #{page},#{limit}")
    List<Customer> findAllqiye(@Param("page") int page, @Param("limit") int limit);

    @Select("select * from customer where is_valid=1 and satisfaction='个人'  limit #{page},#{limit}")
    List<Customer> findAllgeren(@Param("page") int page, @Param("limit") int limit);

    @Select("select * from customer where is_valid=1 and level = '重点' limit #{page},#{limit}")
    List<Customer> findAllVIP(@Param("page") int page, @Param("limit") int limit);

    @Select("select * from customer where is_valid=1 and level = '重点' and satisfaction='企业' limit #{page},#{limit}")
    List<Customer> findAllVIPqiye(@Param("page") int page, @Param("limit") int limit);

    @Select("select * from customer where is_valid=1 and level = '重点' and satisfaction='个人' limit #{page},#{limit}")
    List<Customer> findAllVIPgeren(@Param("page") int page, @Param("limit") int limit);


    /**
     * 查询指定客户
     *
     * @return
     */
    @ResultMap("customerMap")
    @Select("select * from customer where is_valid=1 and name like #{name}")
    List<Customer> findOne(@Param("name") String name);

    @ResultMap("customerMap")
    @Select("select * from customer where is_valid=1 and level = '重点' and name like #{name}")
    List<Customer> findOneVip(@Param("name") String name);

    @ResultMap("customerMap")
    @Select("select * from customer where is_valid=1 and satisfaction='企业'  and name like #{name}")
    List<Customer> findOneqiye(@Param("name") String name);

    @ResultMap("customerMap")
    @Select("select * from customer where is_valid=1 and satisfaction='个人'  and name like #{name}")
    List<Customer> findOnegeren(@Param("name") String name);

    @ResultMap("customerMap")
    @Select("select * from customer where is_valid=1 and satisfaction='企业' and level = '重点' and name like #{name}")
    List<Customer> findOneVipqiye(@Param("name") String name);

    @ResultMap("customerMap")
    @Select("select * from customer where is_valid=1 and satisfaction='个人' and level = '重点' and name like #{name}")
    List<Customer> findOneVipgeren(@Param("name") String name);
    /**
     * 查询总客户数
     *
     * @return
     */
    @Select("select count(*) from customer where is_valid=1")
    int findTotal();

    @Select("select count(*) from customer where is_valid=1 and satisfaction='企业'")
    int findTotalqiye();

    @Select("select count(*) from customer where is_valid=1 and satisfaction='个人'")
    int findTotalgeren();

    @Select("select count(*) from customer where is_valid=1 and level = '重点' and satisfaction='个人'")
    int findTotalVipgeren();

    @Select("select count(*) from customer where is_valid=1 and level = '重点' and satisfaction='企业'")
    int findTotalVipqiye();

    @Select("select count(*) from customer where is_valid=1 and level = '重点'")
    int findTotalVip();
    /**
     * 根据id删除客户
     *
     * @return
     */
    @Update("update customer set is_valid=0 where id=#{id}")
    int deleteById(@Param("id") int id);

    @Update(" UPDATE customer a SET level = '重点' WHERE a.id in (select d.cus_id FROM (SELECT SUM(money) sum ,b.cus_id FROM customer_order b GROUP BY cus_id) d where d.SUM>10000)")
    int updateVip();

    /**
     * 添加客户
     *
     * @return
     */
    @Insert("insert into customer values(#{id},#{name},#{area},#{cusManager}," +
            "#{level},#{satisfaction},#{creditLine},#{address},#{postCode}," +
            "#{tel},#{webSite},#{regCaptial},#{depBank},#{depAccount}," +
            "#{yearlyTurnover},#{state},#{isValid},#{createDate},#{updateDate})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class,
            before = false, statement = {"select last_insert_id()"})
    int save(Customer customer);

    /**
     * 修改客户信息
     *
     * @return
     */
    @Update("update customer set name=#{name},area=#{area},cus_manager=#{cusManager}," +
            "level=#{level},satisfaction=#{satisfaction},credit_line=#{creditLine},address=#{address},post_code=#{postCode}," +
            "tel=#{tel},web_site=#{webSite},reg_captial=#{regCaptial},dep_bank=#{depBank},dep_account=#{depAccount}," +
            "yearly_turnover=#{yearlyTurnover},state=#{state},update_date=#{updateDate} where id=#{id}")
    int update(Customer customer);

    /**
     * 删除多个客户
     *
     * @return
     */
    @Update({
            "<script>"
                    + "update customer set is_valid =0 where id in "
                    + "<foreach item='item' index='index' collection='customers' open='(' separator=',' close=')'>"
                    + "#{item.id}"
                    + "</foreach>"
                    + "</script>"
    })
    int deleteMany(@Param("customers") List<Customer> customers);

    /**
     * 流失客户
     * @return
     */
    @Update("update customer set state=1,is_valid=0 where id=#{id}")
    int loss(@Param("id") int id);

    /**
     * 查询一个月内总客户数
     *
     * @return
     */
    @Select("select count(*) FROM customer where create_date between date_sub(now(),interval 1 month) and now();")
    int findOneTotal();

    /**
     * 查询两个月内总客户数
     *
     * @return
     */
    @Select("select count(*) FROM customer where create_date between date_sub(now(),interval 2 month) and now();")
    int findTwoTotal();

    /**
     * 查询三个月内总客户数
     *
     * @return
     */
    @Select("select count(*) FROM customer where create_date between date_sub(now(),interval 3 month) and now();")
    int findThreeTotal();

    /**
     * 查询四个月内总客户数
     *
     * @return
     */
    @Select("select count(*) FROM customer where create_date between date_sub(now(),interval 4 month) and now()")
    int findFourTotal();

    /**
     * 查询五个月内总客户数
     *
     * @return
     */
    @Select("select count(*) FROM customer where create_date between date_sub(now(),interval 5 month) and now()")
    int findFiveTotal();

    /**
     * 查询六个月内总客户数
     *
     * @return
     */
    @Select("select count(*) FROM customer where create_date between date_sub(now(),interval 6 month) and now()")
    int findSixTotal();

}
