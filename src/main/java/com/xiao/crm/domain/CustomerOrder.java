package com.xiao.crm.domain;

import java.io.Serializable;
import java.util.Date;


public class CustomerOrder implements Serializable {

    /**
     * id
     */
    private Integer id;
    /**
     * 客户id
     */
    private Integer cusId;
    /**
     * 订单编号
     */
    private String orderNum;
    /**
     * 订单时间
     */
    private Date orderDate;
    /**
     * 地址
     */
    private String address;
    /**
     * 金额
     */
    private Double money;
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


    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
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

    public void setUpdateDate(Date updatDate) {
        this.updateDate = updatDate;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
                ", cusId=" + cusId +
                ", orderNum=" + orderNum +
                ", orderDate=" + orderDate +
                ", address='" + address + '\'' +
                ", money=" + money +
                ", isValid=" + isValid +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
