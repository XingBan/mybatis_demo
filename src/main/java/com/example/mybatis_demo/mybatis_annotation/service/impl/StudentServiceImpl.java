package com.example.mybatis_demo.mybatis_annotation.service.impl;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.mybatis_demo.mybatis_annotation.dao.StudentMapper;
import com.example.mybatis_demo.mybatis_annotation.dao.StudentDao;
import com.example.mybatis_demo.mybatis_annotation.entity.Student;
import com.example.mybatis_demo.mybatis_annotation.interceptor.DataScope;
import com.example.mybatis_demo.mybatis_annotation.service.StudentService;
import com.example.mybatis_demo.mybatis_annotation.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student findByName(String name) {
        return studentDao.findByName(name);
    }
    @Override
    public void daoInsert(Student student){
         studentDao.insert(student);
    }
    @Override
    public void update(Student student){
         studentDao.update(student);
    }

    @Override
    public List<Student> list() {
        return studentDao.list();
    }

    @Override
    public List<Student> selectProvider() {
        return studentDao.selectProvider();
    }

    @Override
    public Page getAll(Query query) {
        DataScope dataScope = new DataScope();
        dataScope.putAll(query.getCondition());
        query.setRecords(baseMapper.getAll(query, dataScope));
        return query;
    }

    @Override
    public Integer deleteById(Long id) {
        return baseMapper.updateStudentStutasById(id);
    }

    @Override
    public Student finById(Long id) {
        return baseMapper.findById(id);
    }

    @Override
    public Integer updateStudentById(Student student) {
        return baseMapper.updateStudentById(student);
    }

}
