package com.xiao.crm.domain;

import java.io.Serializable;


public class Pages implements Serializable {

    /**
     * 当前页数
     */
    private int page;
    /**
     * 每页显示的条数
     */
    private int limit;
    /**
     * 查询关键字
     */
    private String key;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Pages{" +
                "page=" + page +
                ", limit=" + limit +
                ", key=" + key +
                '}';
    }
}
