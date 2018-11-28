package com.example.mybatis_demo.mybatis_annotation.controller;


import com.example.mybatis_demo.mybatis_annotation.entity.Student;
import com.example.mybatis_demo.mybatis_annotation.response.JsonResponse;
import com.example.mybatis_demo.mybatis_annotation.service.StudentService;
import com.example.mybatis_demo.mybatis_annotation.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "mybatis/findByName")
    public JsonResponse findByStudnetName(@RequestParam(value = "name",required = true) String name){
        return JsonResponse.success(studentService.findByName(name));
    }

    @PostMapping(value = "mybatis/insert")
    public JsonResponse insert(Student student){
        System.out.println(">>>>>>>>>>>>>>>>>>>>"+student);
        studentService.daoInsert(student);
        return JsonResponse.success("修改信息成功！");
    }

    @PutMapping(value = "mybatis/update")
    public JsonResponse update(Student student){
        System.out.println(">>>>>>>>>>>>>>>>>>>>"+student);
        studentService.update(student);
        return JsonResponse.success("修改信息成功！");
    }

    /**
     * 通过Select注解的查询
     * @return
     */
    @GetMapping(value = "mybatis/list")
    public List<Student> list(){
        List<Student> list = studentService.list();
        return list;
    }

    /**
     * 通过SelectProvider注解的查询
     * @return
     */
    @GetMapping(value = "mybatis/selectProvider")
    public List<Student> selectProvider(){
        List<Student> list = studentService.selectProvider();
        return list;
    }

    /**
     * 通过xml的查询
     * @param params
     * @return
     */
    @GetMapping(value = "mybatis/getAll")
    public JsonResponse getAll(@RequestParam Map<String, Object> params){

        return JsonResponse.success(studentService.getAll(new Query(params)));
    }

    @DeleteMapping("baseMapper/deleteById/{id}")
    public JsonResponse DeleteById(@PathVariable("id") Long id){
        return JsonResponse.success(studentService.deleteById(id));
    }

    @GetMapping("baseMapper/findById/{id}")
    public JsonResponse findById(@PathVariable("id") Long id){
        return JsonResponse.success(studentService.finById(id));
    }

    @PutMapping("baseMapper/updateById")
    public JsonResponse updateById(Student student){
        return JsonResponse.success(studentService.updateStudentById(student));
    }


}
