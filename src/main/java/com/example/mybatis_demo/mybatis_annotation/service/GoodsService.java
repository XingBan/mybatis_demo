package com.example.mybatis_demo.mybatis_annotation.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.mybatis_demo.mybatis_annotation.dto.GoodsDTO;
import com.example.mybatis_demo.mybatis_annotation.entity.Goods;
import com.example.mybatis_demo.mybatis_annotation.interceptor.DataScope;
import com.example.mybatis_demo.mybatis_annotation.utils.Query;

import java.util.List;

public interface GoodsService extends IService<Goods>{
    /**
     * 分页查询物品信息
     * @return
     */
    Page selectGoodsPage(Query query);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Goods findGoodsById(Long id);

    /**
     *
     * 更新物品
     * @param goods
     * @return
     */
    Integer updateGoods(Goods goods);

    Long insertGoods(GoodsDTO goods);

}
