package com.example.mybatis_demo.mybatis_annotation.provider;

public class StudentSqlProvider {

    public String selectProvider(){
        return "select * from student where status = '0'";
    }
}
