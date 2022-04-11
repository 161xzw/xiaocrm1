package com.xiao.crm.domain;

import java.io.Serializable;
import java.util.Date;


public class CusDevPlan implements Serializable {

    /**
     * id
     */
    private Integer id;
    /**
     * 营销机会id
     */
    private Integer saleChanceId;
    /**
     * 计划内容
     */
    private String planContent;
    /**
     * 计划日期
     */
    private Date planDate;
    /**
     * 执行效果
     */
    private String exeAffect;
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


    public Integer getSaleChanceId() {
        return saleChanceId;
    }

    public void setSaleChanceId(Integer saleChanceId) {
        this.saleChanceId = saleChanceId;
    }


    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent;
    }


    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }


    public String getExeAffect() {
        return exeAffect;
    }

    public void setExeAffect(String exeAffect) {
        this.exeAffect = exeAffect;
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
        return "CusDevPlan{" +
                "id=" + id +
                ", saleChanceId=" + saleChanceId +
                ", planContent='" + planContent + '\'' +
                ", planDate=" + planDate +
                ", exeAffect='" + exeAffect + '\'' +
                ", isValid=" + isValid +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
