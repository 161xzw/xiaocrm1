package com.xiao.crm.domain;

import java.io.Serializable;
import java.util.Date;


public class CustomerLinkMan implements Serializable {

	/**
	 * id
	 */
  private Integer id;
	/**
	 * 客户id
	 */
  private Integer cusId;
	/**
	 * 联系人名字
	 */
  private String linkMan;
	/**
	 * 性别
	 */
  private String sex;
	/**
	 * 职位
	 */
  private String position;
	/**
	 * 手机号
	 */
  private String tel;
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


  public Integer getCusId() {
    return cusId;
  }

  public void setCusId(Integer cusId) {
    this.cusId = cusId;
  }


  public String getLinkMan() {
    return linkMan;
  }

  public void setLinkMan(String linkMan) {
    this.linkMan = linkMan;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }


  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
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
        return "CustomerLinkMan{" +
                "id=" + id +
                ", cusId=" + cusId +
                ", linkMan='" + linkMan + '\'' +
                ", sex='" + sex + '\'' +
                ", position='" + position + '\'' +
                ", tel='" + tel + '\'' +
                ", isValid=" + isValid +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
