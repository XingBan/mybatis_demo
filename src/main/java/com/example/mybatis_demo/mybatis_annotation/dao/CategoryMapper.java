package com.example.mybatis_demo.mybatis_annotation.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.mybatis_demo.mybatis_annotation.entity.Category;
import com.example.mybatis_demo.mybatis_annotation.interceptor.DataScope;
import com.example.mybatis_demo.mybatis_annotation.utils.Query;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 分页查询
     * @param query
     * @param dataScope
     * @return
     */
    List selectCategoryPage(Query query, DataScope dataScope);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    Category findCategoryById(Long id);

    /**
     * 更新
     * @param category
     * @return
     */
    Integer updateCategory(Category category);

    Long insertCategory(Category category);
}
