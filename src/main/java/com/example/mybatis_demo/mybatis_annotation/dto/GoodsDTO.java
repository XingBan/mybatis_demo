package com.example.mybatis_demo.mybatis_annotation.dto;

import com.example.mybatis_demo.mybatis_annotation.entity.Goods;

public class GoodsDTO extends Goods{
    private String groups;

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }
}
