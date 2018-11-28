package com.example.mybatis_demo.mybatis_annotation.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.mybatis_demo.mybatis_annotation.entity.Student;
import com.example.mybatis_demo.mybatis_annotation.utils.Query;

import java.util.List;

/**
 * 学生业务逻辑接口类
 */
public interface StudentService extends IService<Student> {
    /**
     * 根据学生名称查询学生信息
     * @param name
     * @return
     */
    Student findByName(String name);

    void daoInsert(Student student);

    void update(Student student);

    List<Student> list();

    List<Student> selectProvider();

    Page getAll(Query query);

    Integer deleteById(Long id);

    Student finById(Long id);

    Integer updateStudentById(Student student);
}
