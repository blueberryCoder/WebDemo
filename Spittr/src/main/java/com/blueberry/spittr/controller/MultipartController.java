package com.blueberry.spittr.controller;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.net.SyslogAppender;
import org.apache.velocity.texen.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import java.io.*;

/**
 * Created by Administrator on 11/18/2016.
 */
@Controller
@RequestMapping("/upload")
public class MultipartController implements ServletConfigAware, ServletContextAware {

    private static final String TAG = MultipartController.class.getSimpleName();
    private Logger logger = Logger.getLogger(MultipartController.class);

    private ServletContext servletContext;

    @RequestMapping(method = RequestMethod.GET)
    public String showLoadPage() {
        return "upload";
    }
//    1.
//    @ResponseBody
//    @RequestMapping(method = RequestMethod.POST)
//    public String processMultipartFile(@RequestPart("file") byte[] file) {
//        File dstFile = new File(servletContext.getContextPath() + "/uploads",
//                System.currentTimeMillis() + ".jpg");
//        if (!dstFile.getParentFile().exists()) {
//            dstFile.getParentFile().mkdirs();
//        }
//        FileOutputStream outputStream = null;
//        try {
//            outputStream = new FileOutputStream(dstFile);
//            outputStream.write(file);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            com.blueberry.spittr.utils.FileUtils.close(outputStream);
//        }
//        return "upload Success  文件路径:" + dstFile.getAbsolutePath();
//    }

    //    2.
//    @ResponseBody
//    @RequestMapping(method = RequestMethod.POST)
//    public String processMultipartFile(@RequestParam("file") MultipartFile multipartFile) {
//        String contentType = multipartFile.getContentType();
//        File destFile = new File(servletContext.getContextPath() + "/uploads",multipartFile.getOriginalFilename());
//        try {
//            multipartFile.transferTo(destFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "upload Success 文件路径:" + destFile.getAbsolutePath()
//                + "Content-Type:" + contentType;
//    }

    //3
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String processMultipartFile(@RequestPart("file")Part file){
                String contentType = file.getContentType();
        File destFile = new File(servletContext.getContextPath() + "/uploads",file.getSubmittedFileName());
        try {
            file.write(destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "upload Success 文件路径:" + destFile.getAbsolutePath()
                + "Content-Type:" + contentType;
    }

    @Override
    public void setServletConfig(ServletConfig servletConfig) {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
