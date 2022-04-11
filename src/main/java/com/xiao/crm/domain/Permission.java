package com.xiao.crm.domain;

import java.io.Serializable;
import java.util.Date;


public class Permission implements Serializable {

    /**
     * id
     */
    private Integer id;
    /**
     * 权限等级
     */
    private Integer permissionLevel;
    /**
     * 权限名称
     */
    private String permissionName;
    /**
     * 权限备注
     */
    private String permissionRemarker;
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

    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }


    public String getPermissionRemarker() {
        return permissionRemarker;
    }

    public void setPermissionRemarker(String permissionRemarker) {
        this.permissionRemarker = permissionRemarker;
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
        return "Permission{" +
                "id=" + id +
                ", permissionLevel=" + permissionLevel +
                ", permissionName='" + permissionName + '\'' +
                ", permissionRemarker='" + permissionRemarker + '\'' +
                ", isValid=" + isValid +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
