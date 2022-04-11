package com.xiao.crm.domain;

import java.io.Serializable;
import java.util.Date;


public class SaleChance implements Serializable {

    /**
     * id
     */
    private Integer id;
    /**
     * 机会来源
     */
    private String chanceSource;
    /**
     * 客户名称
     */
    private String customerName;
    /**
     * 成功几率
     */
    private Integer successProbability;
    /**
     * 概要
     */
    private String outline;
    /**
     * 联系人
     */
    private String linkMan;
    /**
     * 手机号
     */
    private String linkTel;
    /**
     * 详情
     */
    private String details;
    /**
     * 创建人
     */
    private String createMan;
    /**
     * 分配人
     */
    private String assignMan;
    /**
     * 分配时间
     */
    private Date assignTime;
    /**
     * 分配状态
     */
    private Integer state;
    /**
     * 开发状态
     */
    private String devResult;
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


    public String getChanceSource() {
        return chanceSource;
    }

    public void setChanceSource(String chanceSource) {
        this.chanceSource = chanceSource;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public Integer getSuccessProbability() {
        return successProbability;
    }

    public void setSuccessProbability(Integer successProbability) {
        this.successProbability = successProbability;
    }


    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }


    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }


    public String getLinkTel() {
        return linkTel;
    }

    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }


    public String getAssignMan() {
        return assignMan;
    }

    public void setAssignMan(String assignMan) {
        this.assignMan = assignMan;
    }


    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    public String getDevResult() {
        return devResult;
    }

    public void setDevResult(String devResult) {
        this.devResult = devResult;
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
        return "SaleChance{" +
                "id=" + id +
                ", chanceSource='" + chanceSource + '\'' +
                ", customerName='" + customerName + '\'' +
                ", successProbability=" + successProbability +
                ", outline='" + outline + '\'' +
                ", linkMan='" + linkMan + '\'' +
                ", linkTel='" + linkTel + '\'' +
                ", details='" + details + '\'' +
                ", createMan='" + createMan + '\'' +
                ", assignMan='" + assignMan + '\'' +
                ", assignTime=" + assignTime +
                ", state=" + state +
                ", devResult='" + devResult + '\'' +
                ", isValid=" + isValid +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
