package com.example.mybatis_demo.mybatis_annotation.utils;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class HttpUtil {

    public static Object export(File file, HttpServletRequest request , HttpServletResponse response) {//ResponseEntity<FileSystemResource>
        if (file == null) {
            System.out.println("file is null!!!!!");
            return null;

        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ServletContext context = request.getServletContext();

        String mimeType = context.getMimeType(file.getAbsolutePath());
        System.out.println("context getMimeType is :"+mimeType);



            try {
                headers.add("Content-Disposition", "attachment; filename=" + new String( file.getName().getBytes("utf-8"),"ISO8859-1" ));

                response.setContentType("image/*");
                InputStream in =  new FileInputStream(file);//u.openStream();
                byte[] bytearray = new byte[1024];
                int len=0;
                while((len=in.read(bytearray))!=-1){
                    response.getOutputStream().write(bytearray);
                }
                response.getOutputStream().flush();//必须清除流，否则图片不能正常显示
                //   u=null;
                in.close();
                System.out.println("close");
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }





        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType(mimeType))
                .body(new FileSystemResource(file));
    }

}
