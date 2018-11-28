package com.example.mybatis_demo.mybatis_annotation.controller;

import com.example.mybatis_demo.mybatis_annotation.dto.CategoryDTO;
import com.example.mybatis_demo.mybatis_annotation.entity.Category;
import com.example.mybatis_demo.mybatis_annotation.response.JsonResponse;
import com.example.mybatis_demo.mybatis_annotation.service.CategoryService;
import com.example.mybatis_demo.mybatis_annotation.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/findAll")
    public JsonResponse findAll(@RequestParam Map<String,Object> map){
        return JsonResponse.success(categoryService.selectCategoryPage(new Query(map)));
    }

    @GetMapping("/findById/{id}")
    public JsonResponse findById(@PathVariable("id") Long id){
        return JsonResponse.success(categoryService.findCategoryById(id));
    }

    @PutMapping("/updateCategory")
    public JsonResponse updateCategory(@RequestParam CategoryDTO category){
        return JsonResponse.success(categoryService.updateCategory(category));
    }

    @PostMapping("/addCategory")
    public JsonResponse addCategory(@RequestBody CategoryDTO category){
        return JsonResponse.success(categoryService.insertCategory(category));
    }

}
