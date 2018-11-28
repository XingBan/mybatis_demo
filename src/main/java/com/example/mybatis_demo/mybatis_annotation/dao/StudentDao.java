package com.example.mybatis_demo.mybatis_annotation.dao;


import com.example.mybatis_demo.mybatis_annotation.entity.Student;
import com.example.mybatis_demo.mybatis_annotation.provider.StudentSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentDao {


    /**
     * @Results 用于填写结果集的多个字段的映射关系
     * @Result 用于填写结果集的单个字段的映射关系
     * @ResultMap 更加ID关联XML里面的<resultMap></resultMap>
     *
     *  property 实体类属性      column 数据库字段
     *
     * @param name
     * @return
     */
    @Select("SELECT * FROM student where name = #{name} and status = '0'")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "description",column = "description"),
            @Result(property = "status",column = "status")
    })
    Student findByName(@Param("name") String name);



    @Select("insert into student(name,sex,description) values(#{name},#{sex},#{description})")
    //@Options(useGeneratedKeys=true,keyProperty="Id")添加id
    void insert(Student student);

    @Update("update student set name = #{name},sex = #{sex},description = #{description} where id = #{id}")
    void update(Student student);


    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "description",column = "description"),
            @Result(property = "status",column = "status")
    })
    @Select("select * from student where status='0'")
    List<Student> list();


    /**
     *      高级注解
     *
     *      @SelectProvider(type=provider.class,method="xxxx")
     *      @InsertProvider
     *      @UpdateProvider
     *      @DeleteProvider
     *
     */
    @SelectProvider(type= StudentSqlProvider.class,method = "selectProvider")
    List<Student> selectProvider();



}
