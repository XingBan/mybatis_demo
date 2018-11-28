package com.example.mybatis_demo.mybatis_annotation.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.mybatis_demo.mybatis_annotation.dao.AttachmentMapper;
import com.example.mybatis_demo.mybatis_annotation.entity.Attachment;
import com.example.mybatis_demo.mybatis_annotation.interceptor.DataScope;
import com.example.mybatis_demo.mybatis_annotation.service.AttachmentService;
import com.example.mybatis_demo.mybatis_annotation.utils.Query;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;

@Service
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper,Attachment> implements AttachmentService{
    @Override
    public Page selectAttachmentPage(Query query) {
        DataScope dataScope = new DataScope();
        dataScope.putAll(query.getCondition());
        query.setRecords(baseMapper.selectAttachmentPage(query,dataScope));

        return query;
    }

    @Override
    public List<Attachment> findByAttachment(Attachment attachment) {
        return baseMapper.findByAttachment(attachment);
    }

    @Override
    public Long insertAttachment(Attachment attachment) {
        baseMapper.insertAttachment(attachment);

        return attachment.getAttachmentId();
    }

    @Override
    public int updateAttachment(Attachment attachment) {
        return baseMapper.updateAttachment(attachment);
    }
}
