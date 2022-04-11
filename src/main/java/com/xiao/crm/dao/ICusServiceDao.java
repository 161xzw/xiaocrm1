package com.xiao.crm.dao;

import com.xiao.crm.domain.CusService;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Repository
public interface ICusServiceDao {

    /**
     * 查询所有客户服务
     * @param page
     * @param limit
     * @return
     */

    @Results(id = "cusServiceMap",
            value = {
                    @Result(id = true,property = "id",column = "id"),
                    @Result(property = "serviceType",column = "service_type"),
                    @Result(property = "outline",column = "outline"),
                    @Result(property = "cusId",column = "cus_id"),
                    @Result(property = "state",column = "state"),
                    @Result(property = "request",column = "request"),
                    @Result(property = "createPeople",column = "create_people"),
                    @Result(property = "isValid",column = "is_valid"),
                    @Result(property = "createDate",column = "create_date"),
                    @Result(property = "updateDate",column = "update_date"),
            })
    @Select("select * from cus_service where is_valid = 1 limit #{page},#{limit}")
    List<CusService> findAll(@Param("page") int page, @Param("limit") int limit);

    /**
     * 根据客户名查询指定客户服务
     * @param request
     * @return
     */
    @RequestMapping("cusServiceMap")
    @Select("select * from cus_service where is_valid = 1 and request like #{request}")
    List<CusService> findOne(@Param("request") String request);

    /**
     * 查询客户服务总数
     * @return
     */
    @Select("select count(*) from cus_service where is_valid = 1")
    int findTotal();

    /**
     * 根据id删除客户服务
     * @param id
     * @return
     */
    @Update("update cus_service set is_valid = 0 where id=#{id}")
    int deleteById(@Param("id") int id);

    /**
     * 删除多个客户服务
     * @param cusServices
     * @return
     */
    @Update({
            "<script>"
                    + "update cus_service set is_valid =0 where id in "
                    + "<foreach item='item' index='index' collection='cusServices' open='(' separator=',' close=')'>"
                    + "#{item.id}"
                    + "</foreach>"
                    + "</script>"
    })
    int deleteMany(@Param("cusServices") List<CusService> cusServices);

    /**
     * 新增客户服务
     * @param cusService
     * @return
     */
    @Insert("insert into cus_service " +
            "(id,service_type,outline,cus_id,state,request,create_people,is_valid,create_date,update_date) " +
            "values (#{id},#{serviceType},#{outline},#{cusId}," +
            "#{state},#{request},#{createPeople},#{isValid},#{createDate},#{updateDate})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class,
            before = false, statement = {"select last_insert_id()"})
    int save(CusService cusService);

    /**
     * 修改客户服务
     * @param cusService
     * @return
     */
    @Update("update cus_service set service_type=#{serviceType},outline=#{outline},cus_id=#{cusId}," +
            "state=#{state},request=#{request},create_people=#{createPeople},update_date=#{updateDate} where id=#{id}")
    int update(CusService cusService);
}
