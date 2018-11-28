package com.example.mybatis_demo.mybatis_annotation.controller;


import com.example.mybatis_demo.mybatis_annotation.entity.Attachment;
import com.example.mybatis_demo.mybatis_annotation.response.JsonResponse;
import com.example.mybatis_demo.mybatis_annotation.service.AttachmentService;
import com.example.mybatis_demo.mybatis_annotation.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guoyuzai
 */
@RestController
@RequestMapping("file")
public class UploadDownController {

    @Autowired
    private AttachmentService attachmentService;

    /**
     * 文件上传
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/update")
    public JsonResponse uploadFile(@RequestParam(value = "file")MultipartFile file, HttpServletRequest request){
        String baseUrl = new SimpleDateFormat("yyyy/MM/dd").format(new Date()) + "/";

        String host = request.getHeader("Origin").substring(0, request.getHeader("Origin").lastIndexOf(":")) + ":" + request.getLocalPort();

        String prepath = "F:/";

        Map<String , String> map = new HashMap<>();

        String filename = file.getOriginalFilename();

        String path = prepath + baseUrl;

        File uploadedFile = new File(path, filename);

        File dest = uploadedFile.getParentFile();

        if (!dest.exists()){
            dest.mkdirs();
        }

        try {
            file.transferTo(uploadedFile);

            Attachment attachment = new Attachment();
            attachment.setFilePath(uploadedFile.getPath());
            attachment.setFileName(filename);
            attachment.setCreateTime(new Date());

            Long id = attachmentService.insertAttachment(attachment);

            String origin = host + "/file/show/" + id;

            map.put("id",id+"");
            map.put("name",filename);
            map.put("filePath",uploadedFile.getPath());
            map.put("url",origin);

            return JsonResponse.success(map);

        } catch (IOException e) {
            e.printStackTrace();
        }
       return JsonResponse.customFail("0001","上传失败");
    }

    /**
     * 文件显示
     * @param id
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = "/show/{id}")
    public Object show(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){

        if (!"".equals(id)) {
            Attachment attachment = new Attachment();
            attachment.setAttachmentId(Long.valueOf(id));

            List<Attachment> list = attachmentService.findByAttachment(attachment);

            if (list.size() != 0) {
                File file = new File(list.get(0).getFilePath());

                return HttpUtil.export(file,request,response);
            }

        }

        return JsonResponse.customFail("0001","id不能为空");
    }

    /**
     * 文件下载
     * @param attachment
     * @param response
     * @param request
     * @return
     */
    @GetMapping(value = "/downloadFile")
    public String downloadFile(Attachment attachment,HttpServletResponse response,HttpServletRequest request){
        Attachment info = attachmentService.findByAttachment(attachment).get(0);

        String fileName = info.getFileName();

        FileInputStream stream = null;
        try {



            stream = new FileInputStream(info.getFilePath());
            response.reset();

            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");

            byte[] bytes = new byte[1024];

            int len;
            while ((len=stream.read(bytes)) > 0){
                response.getOutputStream().write(bytes,0,len);
            }
            stream.close();

            return "success";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "customFail";


    }

}
