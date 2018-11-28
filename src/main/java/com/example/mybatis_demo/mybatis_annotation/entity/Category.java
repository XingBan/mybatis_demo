package com.example.mybatis_demo.mybatis_annotation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 类别
 */
@Entity
public class Category implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 物品管理名称
     */
    private String name;
    /**
     * 标识
     */
    private String identification;
    /**
     * 查询字段
     */
    private String queryfield;
    /**
     * 编辑字段
     */
    private String editfield;
    /**
     * 添加字段
     */
    private String addfield;
    /**
     * 状态
     */
    private String status;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getQueryfield() {
        return queryfield;
    }

    public void setQueryfield(String queryfield) {
        this.queryfield = queryfield;
    }

    public String getEditfield() {
        return editfield;
    }

    public void setEditfield(String editfield) {
        this.editfield = editfield;
    }

    public String getAddfield() {
        return addfield;
    }

    public void setAddfield(String addfield) {
        this.addfield = addfield;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", identification='" + identification + '\'' +
                ", queryfield='" + queryfield + '\'' +
                ", editfield='" + editfield + '\'' +
                ", addfield='" + addfield + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
