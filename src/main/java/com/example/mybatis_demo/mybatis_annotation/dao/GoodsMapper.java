package com.example.mybatis_demo.mybatis_annotation.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.mybatis_demo.mybatis_annotation.dto.GoodsDTO;
import com.example.mybatis_demo.mybatis_annotation.entity.Goods;
import com.example.mybatis_demo.mybatis_annotation.interceptor.DataScope;
import com.example.mybatis_demo.mybatis_annotation.utils.Query;

import java.util.List;

public interface GoodsMapper extends BaseMapper<Goods> {
    /**
     * 分页查询物品信息
     * @return
     */
    List selectGoodsPage(Query query, DataScope dataScope);

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

    GoodsDTO getMaxSort(DataScope dataScope);

    Long insertGoods(Goods goods);
}
