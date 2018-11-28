package com.example.mybatis_demo.mybatis_annotation.controller;

import com.example.mybatis_demo.mybatis_annotation.dto.GoodsDTO;
import com.example.mybatis_demo.mybatis_annotation.entity.Category;
import com.example.mybatis_demo.mybatis_annotation.entity.Goods;
import com.example.mybatis_demo.mybatis_annotation.response.JsonResponse;
import com.example.mybatis_demo.mybatis_annotation.service.GoodsService;
import com.example.mybatis_demo.mybatis_annotation.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/findAll")
    public JsonResponse findAll(@RequestParam Map<String,Object> map){
        return JsonResponse.success(goodsService.selectGoodsPage(new Query(map)));
    }

    @GetMapping("/findById/{id}")
    public JsonResponse findById(@PathVariable("id") Long id){
        return JsonResponse.success(goodsService.findGoodsById(id));
    }

    @PutMapping("/updateGoods")
    public JsonResponse updateCategory(@RequestParam Goods goods){
        return JsonResponse.success(goodsService.updateGoods(goods));
    }
    @PostMapping("/addGoods")
    public JsonResponse addGoods(@RequestParam GoodsDTO goods){
        return JsonResponse.success(goodsService.insertGoods(goods));
    }
}
