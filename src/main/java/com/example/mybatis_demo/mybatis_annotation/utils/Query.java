package com.example.mybatis_demo.mybatis_annotation.utils;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.example.mybatis_demo.mybatis_annotation.xss.SQLFilter;


import java.util.Map;

/**
 * 查询通用类
 * @param <T>
 */
public class Query<T> extends Page<T> {

    private static final String PAGE = "page";
    private static final String LIMIT = "limit";
    private static final String ORDER_BY_FIELD = "orderByField";
    private static final String IS_ASC = "isAsc";

    public Query(Map<String, Object> params) {
        super(Integer.parseInt(params.getOrDefault(PAGE, 1).toString())
                , Integer.parseInt(params.getOrDefault(LIMIT, 10).toString()));

        String orderByField = params.getOrDefault(ORDER_BY_FIELD, "").toString();
        if (StringUtils.isNotEmpty(orderByField)) {
            //防止SQL注入,通过拼接SQL实现排序的，会有SQL注入风险
            this.setOrderByField(SQLFilter.sqlInject(orderByField));
        }

        Boolean isAsc = Boolean.parseBoolean(params.getOrDefault(IS_ASC, Boolean.TRUE).toString());
        this.setAsc(isAsc);

        params.remove(PAGE);
        params.remove(LIMIT);
        params.remove(ORDER_BY_FIELD);
        params.remove(IS_ASC);
        this.setCondition(params);
    }
}
