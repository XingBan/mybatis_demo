package com.example.mybatis_demo.mybatis_annotation.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.mybatis_demo.mybatis_annotation.entity.Student;
import com.example.mybatis_demo.mybatis_annotation.interceptor.DataScope;
import com.example.mybatis_demo.mybatis_annotation.utils.Query;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 学生mapper
 * @author guoyuzai
 */

public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 获取所有
     * @return
     */
    List getAll(Query query, DataScope dataScope);

    Integer updateStudentStutasById(Long id);

    Student findById(Long id);

    Integer updateStudentById(Student student);
}
