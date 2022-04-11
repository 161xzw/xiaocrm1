package com.xiao.crm.domain;

import java.io.Serializable;
import java.util.Date;


public class CustomerContact implements Serializable {

    /**
     * id
     */
    private Integer id;
    /**
     * 客户id
     */
    private Integer cusId;
    /**
     * 联系人id
     */
    private Integer linkManId;
    /**
     * 交往时间
     */
    private Date contactTime;
    /**
     * 交往地址
     */
    private String address;
    /**
     * 概要
     */
    private String outline;
    /**
     * 有效时间
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

    public Integer getLinkManId() {
        return linkManId;
    }

    public void setLinkManId(Integer linkManId) {
        this.linkManId = linkManId;
    }

    public Date getContactTime() {
        return contactTime;
    }

    public void setContactTime(Date contactTime) {
        this.contactTime = contactTime;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
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
        return "CustomerContact{" +
                "id=" + id +
                ", cusId=" + cusId +
                ", linkManId=" + linkManId +
                ", contactTime=" + contactTime +
                ", address='" + address + '\'' +
                ", outline='" + outline + '\'' +
                ", isValid=" + isValid +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
