package com.example.mybatis_demo.mybatis_annotation.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.mybatis_demo.mybatis_annotation.dto.CategoryDTO;
import com.example.mybatis_demo.mybatis_annotation.entity.Category;
import com.example.mybatis_demo.mybatis_annotation.interceptor.DataScope;
import com.example.mybatis_demo.mybatis_annotation.utils.Query;

import java.util.List;

public interface CategoryService extends IService<Category> {
    /**
     * 分页查询
     * @param query
     * @param
     * @return
     */
    Page selectCategoryPage(Query query);

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
    Integer updateCategory(CategoryDTO category);


    Long insertCategory(CategoryDTO category);
}
