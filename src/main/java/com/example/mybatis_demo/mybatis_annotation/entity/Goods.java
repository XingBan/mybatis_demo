package com.example.mybatis_demo.mybatis_annotation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 物品
 */
@Entity
public class Goods implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 描述
     */
    private String description;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 类别id
     */
    private Long categoryid;

    /**
     * 码数
     */
    private String yardage;

    /**
     * 正面图片地址
     */
    private String frontImgUrl;

    /**
     * 背面
     */
    private String behindImgUrl;

    /**
     * 侧面
     */
    private String sideImgUrl;

    /**
     * 上面
     */
    private String aboveImgUrl;
    /**
     * 下面
     */
    private String belowImgUrl;

    /**
     * 标题
     */
    private String title;

    /**
     * 排序
     */
    private String sort;

    private Date createTime;

    private Date updateTime;
    /**
     * 是否显示
     */
    private String isshow;
    /**
     * 分组
     */
    private String groupid;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public String getYardage() {
        return yardage;
    }

    public void setYardage(String yardage) {
        this.yardage = yardage;
    }

    public String getFrontImgUrl() {
        return frontImgUrl;
    }

    public void setFrontImgUrl(String frontImgUrl) {
        this.frontImgUrl = frontImgUrl;
    }

    public String getBehindImgUrl() {
        return behindImgUrl;
    }

    public void setBehindImgUrl(String behindImgUrl) {
        this.behindImgUrl = behindImgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getSideImgUrl() {
        return sideImgUrl;
    }

    public void setSideImgUrl(String sideImgUrl) {
        this.sideImgUrl = sideImgUrl;
    }

    public String getAboveImgUrl() {
        return aboveImgUrl;
    }

    public void setAboveImgUrl(String aboveImgUrl) {
        this.aboveImgUrl = aboveImgUrl;
    }

    public String getBelowImgUrl() {
        return belowImgUrl;
    }

    public void setBelowImgUrl(String belowImgUrl) {
        this.belowImgUrl = belowImgUrl;
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

    public String getIsshow() {
        return isshow;
    }

    public void setIsshow(String isshow) {
        this.isshow = isshow;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
}
