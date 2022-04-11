package com.xiao.crm.dao;

import com.xiao.crm.domain.Permission;
import com.xiao.crm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IPermissionDao {

    /**
     * 查询所有权限
     *
     * @return
     */
    @Results(id = "permissionMap",
            value = {
                    @Result(id = true, property = "id", column = "id"),
                    @Result(property = "permissionLevel", column = "permission_level"),
                    @Result(property = "permissionName", column = "permission_name"),
                    @Result(property = "permissionRemarker", column = "permission_remarker"),
                    @Result(property = "isValid", column = "is_valid"),
                    @Result(property = "createDate", column = "create_date"),
                    @Result(property = "updateDate", column = "update_date"),
            })
    @Select("select * from permission limit #{page},#{limit}")
    List<Permission> findAll(@Param("page") int page, @Param("limit") int limit);

    /**
     * 查询指定权限
     *
     * @return
     */
    @ResultMap("permissionMap")
    @Select("select * from permission where permission_name like #{permissionName}")
    List<Permission> findOne(@Param("permissionName") String name);

    @ResultMap("permissionMap")
    @Select("select * from permission where id=#{id}")
    List<Permission> findOneByID(@Param("id") int id);
    /**
     * 查询总权限数
     *
     * @return
     */
    @Select("select count(*) from permission")
    int findTotal();

    /**
     * 根据id删除权限
     *
     * @return
     */
    @Update("update permission set is_valid=0 where id=#{id}")
    int deleteById(@Param("id") int id);

    /**
     * 添加权限
     *
     * @return
     */
    @Insert("insert into permission values(#{id},#{permissionLevel},#{permissionName},#{permissionRemarker}," +
            "#{isValid},#{createDate},#{updateDate})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Integer.class,
            before = false, statement = {"select last_insert_id()"})
    int save(Permission permission);

    /**
     * 修改权限信息
     *
     * @return
     */
    @Update("update permission set permission_level=#{permissionLevel},permission_name=#{permissionName},permission_remarker=#{permissionRemarker}," +
            "is_valid=#{isValid},update_date=#{updateDate} where id=#{id}")
    int update(Permission permission);

    /**
     * 删除多个权限
     *
     * @return
     */
    @Update({
            "<script>"
                    + "update permission set is_valid =0 where id in "
                    + "<foreach item='item' index='index' collection='permissions' open='(' separator=',' close=')'>"
                    + "#{item.id}"
                    + "</foreach>"
                    + "</script>"
    })
    int deleteMany(@Param("permissions") List<Permission> permissions);

    /**
     * 查询角色对应的权限
     *
     * @return
     */
    @ResultMap("permissionMap")
    @Select("select * from permission where id in (select permission_id from role_permission where role_id=#{roleId} and is_valid=1)")
    List<Role> findPermission(Integer roleId);
}
