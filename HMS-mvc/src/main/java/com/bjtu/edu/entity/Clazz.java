package com.bjtu.edu.entity;

import java.util.Date;

/**
 * @project: mvc
 * @description: 班级实体类
 * @author: wanShun
 * @create: 2022/11/30
 */
public class Clazz {
    //班级ID
    private Long clazzId;
    //班级人数
    private Integer clazzNumber;
    //简介
    private String clazzDesc;
    //创建时间
    private Date createTime;
    //更新时间
    private Date lastEditTime;

    public Long getClazzId() {
        return clazzId;
    }

    public void setClazzId(Long clazzId) {
        this.clazzId = clazzId;
    }

    public Integer getClazzNumber() {
        return clazzNumber;
    }

    public void setClazzNumber(Integer clazzNumber) {
        this.clazzNumber = clazzNumber;
    }

    public String getClazzDesc() {
        return clazzDesc;
    }

    public void setClazzDesc(String clazzDesc) {
        this.clazzDesc = clazzDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
