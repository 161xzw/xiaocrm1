package com.xiao.crm.domain;

import java.io.Serializable;
import java.util.Date;


public class UserRole implements Serializable {

	/**
	 * id
	 */
  private Integer id;
	/**
	 * 用户id
	 */
  private Integer userId;
	/**
	 * 角色id
	 */
  private Integer roleId;
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


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
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

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                ", isValid=" + isValid +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
