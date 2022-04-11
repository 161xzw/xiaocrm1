package com.xiao.crm.dao;

import com.xiao.crm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IRoleDao {

    /**
     * 查询所有角色
     *
     * @return
     */
    @Results(id = "roleMap",
            value = {
                    @Result(id = true, property = "id", column = "id"),
                    @Result(property = "roleName", column = "role_name"),
                    @Result(property = "roleRemarker", column = "role_remarker"),
                    @Result(property = "isValid", column = "is_valid"),
                    @Result(property = "createDate", column = "create_date"),
                    @Result(property = "updateDate", column = "update_date"),
            })
    @Select("select * from role limit #{page},#{limit}")
    List<Role> findAll(@Param("page") int page, @Param("limit") int limit);

    /**
     * 查询指定角色
     *
     * @return
     */
    @ResultMap("roleMap")
    @Select("select * from role where role_name like #{roleName}")
    List<Role> findOne(@Param("roleName") String name);

    /**
     * 根据ID查权限名称
     *
     * @return
     */
    @ResultMap("roleMap")
    @Select("select * from role where id=#{id}")
    List<Role>findOneByID(@Param("id") int id);

    /**
     * 查询总角色数
     *
     * @return
     */
    @Select("select count(*) from role")
    int findTotal();

    /**
     * 根据id删除角色
     *
     * @return
     */
    @Update("update role set is_valid=0 where id=#{id}")
    int deleteById(@Param("id") int id);

    /**
     * 添加角色
     *
     * @return
     */
    @Insert("insert into role values(#{id},#{roleName},#{roleRemarker}," +
            "#{isValid},#{createDate},#{updateDate})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class,
            before = false, statement = {"select last_insert_id()"})
    int save(Role role);

    /**
     * 修改角色信息
     *
     * @return
     */
    @Update("update role set role_name=#{roleName},role_remarker=#{roleRemarker}," +
            "is_valid=#{isValid},update_date=#{updateDate} where id=#{id}")
    int update(Role role);

    /**
     * 删除多个角色
     *
     * @return
     */
    @Update({
            "<script>"
                    + "update role set is_valid =0 where id in "
                    + "<foreach item='item' index='index' collection='roles' open='(' separator=',' close=')'>"
                    + "#{item.id}"
                    + "</foreach>"
                    + "</script>"
    })
    int deleteMany(@Param("roles") List<Role> roles);

    /**
     * 查询用户对应的角色（多对多）
     *
     * @return
     */
    @Results(id = "rolePermissionMap",
            value = {
                    @Result(id = true, property = "id", column = "id"),
                    @Result(property = "roleName", column = "role_name"),
                    @Result(property = "roleRemarker", column = "role_remarker"),
                    @Result(property = "isValid", column = "is_valid"),
                    @Result(property = "createDate", column = "create_date"),
                    @Result(property = "updateDate", column = "update_date"),
                    @Result(column = "id",
                            property = "permissions",
                            many = @Many(select = "com.crm.dao.IPermissionDao.findPermission", fetchType = FetchType.LAZY)
                    )
            })
    @Select("select * from role where id in (select role_id from user_role where user_id=#{userId} and is_valid=1)")
    List<Role> findRolePermission(Integer userId);
}
