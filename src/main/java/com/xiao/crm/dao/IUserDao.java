package com.xiao.crm.dao;

import com.xiao.crm.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Candy
 * @date: 2020/11/23 14:45
 * @description: 用户接口
 */

@Repository
public interface IUserDao {

    /**
     * 查询所有用户
     *
     * @return
     */
    @Results(id = "userMap",
            value = {
                    @Result(id = true, property = "id", column = "id"),
                    @Result(property = "userName", column = "user_name"),
                    @Result(property = "userPwd", column = "user_pwd"),
                    @Result(property = "trueName", column = "true_name"),
                    @Result(property = "email", column = "email"),
                    @Result(property = "tel", column = "tel"),
                    @Result(property = "isValid", column = "is_valid"),
                    @Result(property = "createDate", column = "create_date"),
                    @Result(property = "updateDate", column = "update_date"),
            })
    @Select("select * from user limit #{page},#{limit}")
    List<User> findAll(@Param("page") int page, @Param("limit") int limit);

    /**
     * 根据用户名查询指定用户
     *
     * @param user_name
     * @return
     */
    @ResultMap("userMap")
    @Select("select * from user where user_name like #{user_name}")
    List<User> findOne(@Param("user_name") String user_name);

    /**
     * 校检登录
     *
     * @param userName
     * @param userPwd
     * @return
     */
    @ResultMap("userRoleMap")
    @Select("select * from user where user_name=#{userName} and user_pwd=#{userPwd}")
    User checkLogin(@Param("userName") String userName, @Param("userPwd") String userPwd);

    /**
     * 查询用户总数
     *
     * @return
     */
    @Select("select count(*) from user")
    int findTotal();

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @Update("update user set is_valid=0 where id=#{id}")
    int deleteById(@Param("id") int id);

    /**
     * 删除多个用户
     *
     * @param users
     * @return
     */
    @Update({
            "<script>"
                    + "update user set is_valid =0 where id in "
                    + "<foreach item='item' index='index' collection='users' open='(' separator=',' close=')'>"
                    + "#{item.id}"
                    + "</foreach>"
                    + "</script>"
    })
    int deleteMany(@Param("users") List<User> users);

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @Insert("insert into user values (#{id},#{userName},#{userPwd},#{trueName}," +
            "#{email},#{tel},#{isValid},#{createDate},#{updateDate})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class,
            before = false, statement = {"select last_insert_id()"})
    int save(User user);

    /**
     * 修改用户信息
     *
     * @return
     */
    @Update("update user set user_name=#{userName},user_pwd=#{userPwd},true_name=#{trueName}," +
            "email=#{email},tel=#{tel},is_valid=#{isValid},update_date=#{updateDate} where id=#{id}")
    int update(User user);

    /**
     * 查询用户及其角色（多对多）
     *
     * @return
     */
    @Results(id = "userRoleMap",
            value = {
                    @Result(id = true, property = "id", column = "id"),
                    @Result(property = "userName", column = "user_name"),
                    @Result(property = "userPwd", column = "user_pwd"),
                    @Result(property = "trueName", column = "true_name"),
                    @Result(property = "email", column = "email"),
                    @Result(property = "tel", column = "tel"),
                    @Result(property = "isValid", column = "is_valid"),
                    @Result(property = "createDate", column = "create_date"),
                    @Result(property = "updateDate", column = "update_date"),
                    @Result(column = "id",
                            property = "roles",
                            many = @Many(select = "com.crm.dao.IRoleDao.findRolePermission", fetchType = FetchType.LAZY)
                    )
            })
    @Select("select * from user where user_name=#{userName}")
    List<User> findUserRole(String userName);
}
