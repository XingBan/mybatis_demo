package com.example.mybatis_demo.mybatis_annotation.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.mybatis_demo.mybatis_annotation.dao.GoodsMapper;
import com.example.mybatis_demo.mybatis_annotation.dto.GoodsDTO;
import com.example.mybatis_demo.mybatis_annotation.entity.Goods;
import com.example.mybatis_demo.mybatis_annotation.interceptor.DataScope;
import com.example.mybatis_demo.mybatis_annotation.service.GoodsService;
import com.example.mybatis_demo.mybatis_annotation.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper,Goods>  implements GoodsService {
    @Override
    public Page selectGoodsPage(Query query) {
        DataScope dataScope = new DataScope();
        dataScope.putAll(query.getCondition());
        query.setRecords(baseMapper.selectGoodsPage(query, dataScope));
        return query;
    }

    @Override
    public Goods findGoodsById(Long id) {
        return baseMapper.findGoodsById(id);
    }

    @Override
    public Integer updateGoods(Goods goods) {
        return baseMapper.updateGoods(goods);
    }

    @Override
    public Long insertGoods(GoodsDTO goodsDTO) {
        Goods goods = new Goods();
        DataScope dataScope = new DataScope();

        dataScope.put("groupid",goodsDTO.getGroups());
        GoodsDTO maxSort = baseMapper.getMaxSort(dataScope);
        BeanUtils.copyProperties(goodsDTO,goods);
        goods.setCreateTime(new Date());
        goods.setGroupid(goodsDTO.getGroups());
        if (null !=maxSort && StringUtils.isNotBlank(maxSort.getSort())) {
            int sort = Integer.parseInt(maxSort.getSort())+2;
            goods.setSort(sort+"");
        }else{
            goods.setSort("2");
        }
        baseMapper.insertGoods(goods);
        return goods.getId();
    }
}
