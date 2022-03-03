package com.xiao.crm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* 角色实体类
* @author : Bei-Zhen
*/
public class Role implements Serializable {

	/**
	 * id
	 */
  private Integer id;
	/**
	 * 角色名称
	 */
  private String roleName;
	/**
	 * 角色备注
	 */
  private String roleRemarker;
	/**
	 * 有效状态
	 */
  private Integer isValid;
	/**
	 * 创建时间
	 */
  private Date createDate;
	/**
	 * 更新时间
	 */
  private Date updateDate;

    /**
     * 多对多关系映射：一个角色可以拥有多种权限
     */
  List<Permission> permissions;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


  public String getRoleRemarker() {
    return roleRemarker;
  }

  public void setRoleRemarker(String roleRemarker) {
    this.roleRemarker = roleRemarker;
  }


  public Integer getIsValid() {
    return isValid;
  }

  public void setIsValid(Integer isValid) {
    this.isValid = isValid;
  }


  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }


  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleRemarker='" + roleRemarker + '\'' +
                ", isValid=" + isValid +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", permissions=" + permissions +
                '}';
    }
}
