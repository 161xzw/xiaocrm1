package com.xiao.crm.dao;

import com.xiao.crm.domain.UserRole;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Bei-Zhen
 * @date : 2020-12-06 1:42
 */
@Repository
public interface IUserRoleDao {

    /**
     * 查询所有用户角色
     *
     * @return
     */
    @Results(id = "userRoleMap",
            value = {
                    @Result(id = true, property = "id", column = "id"),
                    @Result(property = "userId", column = "user_id"),
                    @Result(property = "roleId", column = "role_id"),
                    @Result(property = "isValid", column = "is_valid"),
                    @Result(property = "createDate", column = "create_date"),
                    @Result(property = "updateDate", column = "update_date"),
            })
    @Select("select * from user_role where user_id=#{userId} limit #{page},#{limit}")
    List<UserRole> findAll(@Param("page") int page, @Param("limit") int limit, @Param("userId") int userId);

    /**
     * 查询指定用户角色
     *
     * @return
     */
    @ResultMap("userRoleMap")
    @Select("select * from user_role where user_id=#{userId}")
    List<UserRole> findOne(@Param("userId") int userId);

    /**
     * 查询总用户角色数
     *
     * @return
     */
    @Select("select count(*) from user_role where user_id=#{userId}")
    int findTotal(@Param("userId") int userId);

    /**
     * 根据id删除用户角色
     *
     * @return
     */
    @Update("update user_role set is_valid=0 where id=#{id}")
    int deleteById(@Param("id") int id);

    /**
     * 添加用户角色
     *
     * @return
     */
    @Insert("insert into user_role values(#{id},#{userId},#{roleId}," +
            "#{isValid},#{createDate},#{updateDate})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class,
            before = false, statement = {"select last_insert_id()"})
    int save(UserRole userRole);

    /**
     * 修改用户角色信息
     *
     * @return
     */
    @Update("update user_role set user_id=#{userId},role_id=#{roleId}," +
            "is_valid=#{isValid},update_date=#{updateDate} where id=#{id}")
    int update(UserRole userRole);

    /**
     * 删除多个用户角色
     *
     * @return
     */
    @Update({
            "<script>"
                    + "update user_role set is_valid =0 where id in "
                    + "<foreach item='item' index='index' collection='userRoles' open='(' separator=',' close=')'>"
                    + "#{item.id}"
                    + "</foreach>"
                    + "</script>"
    })
    int deleteMany(@Param("userRoles") List<UserRole> userRoles);


}
