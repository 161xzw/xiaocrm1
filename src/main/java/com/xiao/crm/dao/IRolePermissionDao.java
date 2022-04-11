package com.xiao.crm.dao;

import com.xiao.crm.domain.RolePermission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IRolePermissionDao {

    /**
     * 查询所有角色权限
     *
     * @return
     */
    @Results(id = "rolePermissionMap",
            value = {
                    @Result(id = true, property = "id", column = "id"),
                    @Result(property = "roleId", column = "role_id"),
                    @Result(property = "permissionId", column = "permission_id"),
                    @Result(property = "isValid", column = "is_valid"),
                    @Result(property = "createDate", column = "create_date"),
                    @Result(property = "updateDate", column = "update_date"),
            })
    @Select("select * from role_permission where role_id=#{roleId} limit #{page},#{limit}")
    List<RolePermission> findAll(@Param("page") int page, @Param("limit") int limit, @Param("roleId") int roleId);

    /**
     * 查询指定角色权限
     *
     * @return
     */
    @ResultMap("rolePermissionMap")
    @Select("select * from role_permission where role_id=#{roleId}")
    List<RolePermission> findOne(@Param("roleId") int roleId);

    @Select("select permission_id from role_permission where role_id=#{roleId}")
    int findOneID(@Param("roleId") int roleId);

    /**
     * 查询总角色权限数
     *
     * @return
     */
    @Select("select count(*) from role_permission where role_id=#{roleId}")
    int findTotal(@Param("roleId") int roleId);

    /**
     * 根据id删除角色权限
     *
     * @return
     */
    @Update("update role_permission set is_valid=0 where id=#{id}")
    int deleteById(@Param("id") int id);

    /**
     * 添加角色权限
     *
     * @return
     */
    @Insert("insert into role_permission values(#{id},#{roleId},#{permissionId}," +
            "#{isValid},#{createDate},#{updateDate})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class,
            before = false, statement = {"select last_insert_id()"})
    int save(RolePermission rolePermission);

    /**
     * 修改角色权限信息
     *
     * @return
     */
    @Update("update role_permission set role_id=#{roleId},permission_id=#{permissionId}," +
            "is_valid=#{isValid},update_date=#{updateDate} where id=#{id}")
    int update(RolePermission rolePermission);

    /**
     * 删除多个角色权限
     *
     * @return
     */
    @Update({
            "<script>"
                    + "update role_permission set is_valid =0 where id in "
                    + "<foreach item='item' index='index' collection='permissions' open='(' separator=',' close=')'>"
                    + "#{item.id}"
                    + "</foreach>"
                    + "</script>"
    })
    int deleteMany(@Param("permissions") List<RolePermission> permissions);
}
