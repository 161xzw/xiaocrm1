package com.xiao.crm.domain;

import java.io.Serializable;
import java.util.Date;


public class Customer implements Serializable {

    /**
     * id
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 地区
     */
    private String area;
    /**
     * 经理
     */
    private String cusManager;
    /**
     * 级别
     */
    private String level;
    /**
     * 满意度
     */
    private String satisfaction;
    /**
     * 信用度
     */
    private String creditLine;
    /**
     * 客户地址
     */
    private String address;
    /**
     * 邮编
     */
    private String postCode;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 网址
     */
    private String webSite;
    /**
     * 注册资金
     */
    private String regCaptial;
    /**
     * 开户银行
     */
    private String depBank;
    /**
     * 开户账号
     */
    private String depAccount;
    /**
     * 年营业额
     */
    private String yearlyTurnover;
    /**
     * 流失状态
     */
    private Integer state;
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
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 县
     */
    private String district;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


    public String getCusManager() {
        return cusManager;
    }

    public void setCusManager(String cusManager) {
        this.cusManager = cusManager;
    }


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }


    public String getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(String creditLine) {
        this.creditLine = creditLine;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }


    public String getRegCaptial() {
        return regCaptial;
    }

    public void setRegCaptial(String regCaptial) {
        this.regCaptial = regCaptial;
    }


    public String getDepBank() {
        return depBank;
    }

    public void setDepBank(String depBank) {
        this.depBank = depBank;
    }


    public String getDepAccount() {
        return depAccount;
    }

    public void setDepAccount(String depAccount) {
        this.depAccount = depAccount;
    }


    public String getYearlyTurnover() {
        return yearlyTurnover;
    }

    public void setYearlyTurnover(String yearlyTurnover) {
        this.yearlyTurnover = yearlyTurnover;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", cusManager='" + cusManager + '\'' +
                ", level='" + level + '\'' +
                ", satisfaction='" + satisfaction + '\'' +
                ", creditLine='" + creditLine + '\'' +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                ", tel='" + tel + '\'' +
                ", webSite='" + webSite + '\'' +
                ", regCaptial='" + regCaptial + '\'' +
                ", depBank='" + depBank + '\'' +
                ", depAccount='" + depAccount + '\'' +
                ", yearlyTurnover='" + yearlyTurnover + '\'' +
                ", state=" + state +
                ", isValid=" + isValid +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
