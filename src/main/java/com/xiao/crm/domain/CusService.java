package com.xiao.crm.domain;

import java.io.Serializable;
import java.util.Date;


public class CusService implements Serializable {

	/**
	 * id
	 */
  private Integer id;
	/**
	 * 服务类型
	 */
  private String serviceType;
	/**
	 * 概要
	 */
  private String outline;
	/**
	 * 客户编号
	 */
  private Integer cusId;
	/**
	 * 服务状态
	 */
  private String state;
	/**
	 * 服务请求
	 */
  private String request;
	/**
	 * 服务创建人
	 */
  private String createPeople;
	/**
	 * 服务分配人
	 */
  private String assigner;
	/**
	 * 分配时间
	 */
  private Date assignTime;
	/**
	 * 服务处理
	 */
  private String serviceProce;
	/**
	 * 服务处理人
	 */
  private String serviceProcePeople;
	/**
	 * 服务处理时间
	 */
  private Date serviceProceTime;
	/**
	 * 服务处理结果
	 */
  private String serviceProceResult;
	/**
	 * 满意度
	 */
  private String satisfaction;
	/**
	 * 是否有效
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


  public String getServiceType() {
    return serviceType;
  }

  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
  }


  public String getOutline() {
    return outline;
  }

  public void setOutline(String outline) {
    this.outline = outline;
  }


    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String getRequest() {
    return request;
  }

  public void setRequest(String request) {
    this.request = request;
  }


  public String getCreatePeople() {
    return createPeople;
  }

  public void setCreatePeople(String createPeople) {
    this.createPeople = createPeople;
  }


  public String getAssigner() {
    return assigner;
  }

  public void setAssigner(String assigner) {
    this.assigner = assigner;
  }


  public Date getAssignTime() {
    return assignTime;
  }

  public void setAssignTime(Date assignTime) {
    this.assignTime = assignTime;
  }


  public String getServiceProce() {
    return serviceProce;
  }

  public void setServiceProce(String serviceProce) {
    this.serviceProce = serviceProce;
  }


  public String getServiceProcePeople() {
    return serviceProcePeople;
  }

  public void setServiceProcePeople(String serviceProcePeople) {
    this.serviceProcePeople = serviceProcePeople;
  }


  public Date getServiceProceTime() {
    return serviceProceTime;
  }

  public void setServiceProceTime(Date serviceProceTime) {
    this.serviceProceTime = serviceProceTime;
  }


  public String getServiceProceResult() {
    return serviceProceResult;
  }

  public void setServiceProceResult(String serviceProceResult) {
    this.serviceProceResult = serviceProceResult;
  }


  public String getSatisfaction() {
    return satisfaction;
  }

  public void setSatisfaction(String satisfaction) {
    this.satisfaction = satisfaction;
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
        return "CusService{" +
                "id=" + id +
                ", serviceType='" + serviceType + '\'' +
                ", outline='" + outline + '\'' +
                ", cusId='" + cusId + '\'' +
                ", state='" + state + '\'' +
                ", request='" + request + '\'' +
                ", createPeople='" + createPeople + '\'' +
                ", assigner='" + assigner + '\'' +
                ", assignTime=" + assignTime +
                ", serviceProce='" + serviceProce + '\'' +
                ", serviceProcePeople='" + serviceProcePeople + '\'' +
                ", serviceProceTime=" + serviceProceTime +
                ", serviceProceResult='" + serviceProceResult + '\'' +
                ", satisfaction='" + satisfaction + '\'' +
                ", isValid=" + isValid +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
