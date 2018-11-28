package com.example.mybatis_demo.mybatis_annotation.xss;


import com.example.mybatis_demo.mybatis_annotation.enums.BaseResultCode;
import com.example.mybatis_demo.mybatis_annotation.utils.ResultCodeUtil;
import org.apache.commons.lang.StringUtils;

/**
 * sql过滤
 */
public class SQLFilter {


    /**
     * SQL注入过滤
     * @param str  待验证的字符串
     */
    public static String sqlInject(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //转换成小写
        str = str.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alert", "drop"};

        //判断是否包含非法字符
        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                ResultCodeUtil.pop(BaseResultCode.ILLEGAL_PARAMS);
            }
        }

        return str;
    }
}
