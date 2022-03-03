package com.xiao.crm.domain;

import java.io.Serializable;
import java.util.Date;

/**
* 实体
* @author : Bei-Zhen
*/
public class CustomerLoss implements Serializable {

	/**
	 * id
	 */
  private Integer id;
	/**
	 * 客户编号
	 */
  private Integer cusId;
	/**
	 * 客户姓名
	 */
  private String cusName;
	/**
	 * 客户经理
	 */
  private String cusManger;
	/**
	 * 最后下单时间
	 */
  private Date lastOrderTime;
	/**
	 * 确认流失时间
	 */
  private Date confirmLossTime;
	/**
	 * 流失状态
	 */
  private Integer state;
	/**
	 * 流失原因
	 */
  private String lossReason;
	/**
	 * 有效状态
	 */
  private Integer isValid;
	/**
	 * 创建时间
	 */
  private Date createTime;
	/**
	 * 更新时间
	 */
  private Date updateTime;


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


  public String getCusName() {
    return cusName;
  }

  public void setCusName(String cusName) {
    this.cusName = cusName;
  }


  public String getCusManger() {
    return cusManger;
  }

  public void setCusManger(String cusManger) {
    this.cusManger = cusManger;
  }


  public Date getLastOrderTime() {
    return lastOrderTime;
  }

  public void setLastOrderTime(Date lastOrderTime) {
    this.lastOrderTime = lastOrderTime;
  }


  public Date getConfirmLossTime() {
    return confirmLossTime;
  }

  public void setConfirmLossTime(Date confirmLossTime) {
    this.confirmLossTime = confirmLossTime;
  }


  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }


  public String getLossReason() {
    return lossReason;
  }

  public void setLossReason(String lossReason) {
    this.lossReason = lossReason;
  }


  public Integer getIsValid() {
    return isValid;
  }

  public void setIsValid(Integer isValid) {
    this.isValid = isValid;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

    @Override
    public String toString() {
        return "CustomerLoss{" +
                "id=" + id +
                ", cusId=" + cusId +
                ", cusName='" + cusName + '\'' +
                ", cusManger='" + cusManger + '\'' +
                ", lastOrderTime=" + lastOrderTime +
                ", confirmLossTime=" + confirmLossTime +
                ", state=" + state +
                ", lossReason='" + lossReason + '\'' +
                ", isValid=" + isValid +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
