package com.example.mybatis_demo.mybatis_annotation.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.mybatis_demo.mybatis_annotation.entity.Attachment;
import com.example.mybatis_demo.mybatis_annotation.interceptor.DataScope;
import com.example.mybatis_demo.mybatis_annotation.utils.Query;

import java.util.List;

public interface AttachmentService extends IService<Attachment>{

    /**
     * 分页查询附件
     * @param query
     * @return
     */
    Page selectAttachmentPage(Query query);

    /**
     * 查询附件
     * @param attachment
     * @return
     */
    List<Attachment> findByAttachment(Attachment attachment);

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
