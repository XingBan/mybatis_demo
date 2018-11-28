package com.example.mybatis_demo.mybatis_annotation.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.mybatis_demo.mybatis_annotation.dao.CategoryMapper;
import com.example.mybatis_demo.mybatis_annotation.dto.CategoryDTO;
import com.example.mybatis_demo.mybatis_annotation.entity.Category;
import com.example.mybatis_demo.mybatis_annotation.interceptor.DataScope;
import com.example.mybatis_demo.mybatis_annotation.service.CategoryService;
import com.example.mybatis_demo.mybatis_annotation.utils.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author guoyuzai
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService{
    @Override
    public Page selectCategoryPage(Query query) {
        DataScope dataScope = new DataScope();
        dataScope.putAll(query.getCondition());
        query.setRecords(baseMapper.selectCategoryPage(query, dataScope));
        return query;
    }

    @Override
    public Category findCategoryById(Long id) {
        return baseMapper.findCategoryById(id);
    }

    @Override
    public Integer updateCategory(CategoryDTO categoryDTO) {
        Category category =new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        //多选项，组成字符串放到表里，以逗号分割
        if(null!=categoryDTO.getQueryfields() && categoryDTO.getQueryfields().length>0) {
            StringBuffer queryfield=new StringBuffer();
            for(int i=0;i<categoryDTO.getQueryfields().length;i++) {
                queryfield.append(categoryDTO.getQueryfields()[i]+",");
            }

            category.setQueryfield(queryfield.toString().substring(0,queryfield.toString().length()-1));
        }
        if(null!=categoryDTO.getEditfields() && categoryDTO.getEditfields().length>0) {
            StringBuffer editfield=new StringBuffer();
            for(int i=0;i<categoryDTO.getEditfields().length;i++) {
                editfield.append(categoryDTO.getEditfields()[i]+",");
            }

            category.setEditfield(editfield.toString().substring(0,editfield.toString().length()-1));
        }
        if(null!=categoryDTO.getAddfields() && categoryDTO.getAddfields().length>0) {
            StringBuffer addfield=new StringBuffer();
            for(int i=0;i<categoryDTO.getAddfields().length;i++) {
                addfield.append(categoryDTO.getAddfields()[i]+",");
            }

            category.setAddfield(addfield.toString().substring(0,addfield.toString().length()-1));
        }
        category.setUpdateTime(new Date());
        category.setStatus("0");

        return baseMapper.updateCategory(category);
    }

    @Override
    public Long insertCategory(CategoryDTO categoryDTO) {

        Category category =new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        //多选项，组成字符串放到表里，以逗号分割
        if(null!=categoryDTO.getQueryfields() && categoryDTO.getQueryfields().length>0) {
            StringBuffer queryfield=new StringBuffer();
            for(int i=0;i<categoryDTO.getQueryfields().length;i++) {
                queryfield.append(categoryDTO.getQueryfields()[i]+",");
            }

            category.setQueryfield(queryfield.toString().substring(0,queryfield.toString().length()-1));
        }
        if(null!=categoryDTO.getEditfields() && categoryDTO.getEditfields().length>0) {
            StringBuffer editfield=new StringBuffer();
            for(int i=0;i<categoryDTO.getEditfields().length;i++) {
                editfield.append(categoryDTO.getEditfields()[i]+",");
            }

            category.setEditfield(editfield.toString().substring(0,editfield.toString().length()-1));
        }
        if(null!=categoryDTO.getAddfields() && categoryDTO.getAddfields().length>0) {
            StringBuffer addfield=new StringBuffer();
            for(int i=0;i<categoryDTO.getAddfields().length;i++) {
                addfield.append(categoryDTO.getAddfields()[i]+",");
            }

            category.setAddfield(addfield.toString().substring(0,addfield.toString().length()-1));
        }
        category.setCreateTime(new Date());
        baseMapper.insertCategory(category);
        return category.getId();
    }
}
