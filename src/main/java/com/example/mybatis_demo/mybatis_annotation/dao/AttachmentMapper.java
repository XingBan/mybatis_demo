package com.example.mybatis_demo.mybatis_annotation.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.mybatis_demo.mybatis_annotation.entity.Attachment;
import com.example.mybatis_demo.mybatis_annotation.interceptor.DataScope;
import com.example.mybatis_demo.mybatis_annotation.utils.Query;

import java.util.List;

public interface AttachmentMapper extends BaseMapper<Attachment>{

    /**
     * 分页查询附件
     * @param query
     * @param dataScope
     * @return
     */
    List selectAttachmentPage(Query query, DataScope dataScope);

    /**
     * 查询附件
     * @param attachment
     * @return
     */
    List findByAttachment(Attachment attachment);

    /**
     * 添加附件
     * @param attachment
     * @return
     */
    Long insertAttachment(Attachment attachment);

    /**
     * 更新附件
     * @param attachment
     * @return
     */
    int updateAttachment(Attachment attachment);


}
