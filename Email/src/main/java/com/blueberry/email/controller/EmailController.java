package com.blueberry.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Administrator on 12/13/2016.
 * https://blogs.oracle.com/java-platform-group/entry/diagnosing_tls_ssl_and_https
 */
@Controller
public class EmailController {
    @Autowired
    JavaMailSender mailSender;

    @RequestMapping(method = RequestMethod.GET,value = "/sendSimple")
    @ResponseBody
    public String sendSimple(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("xxxxxxx@qq.com");
        simpleMailMessage.setTo("xxxxxxx@qq.com");
        simpleMailMessage.setSubject("New spitter from xxx");
        simpleMailMessage.setText("this is text");
        mailSender.send(simpleMailMessage);
        return "send success.";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/sendMime")
    @ResponseBody
    public String sendMime() throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
        helper.setFrom("xxxxxxx@qq.com");
        helper.setTo("xxxxxxx@qq.com");
        helper.setSubject("这是一个主题");


        helper.setText("<html>" +
                "<meta http-equiv=\"Content-Type\" content=\"text/css;charset=utf-8\"/></head>" +
                "<body>图片: <img src='cid:image'/> </body>" +
                "</html>",true);

        ClassPathResource re =new ClassPathResource("/conf/mail.properties");
        helper.addAttachment("resource",re);

        FileSystemResource image = new FileSystemResource("e:/5.jpg");
        helper.addInline("image",image);

        mailSender.send(message);
        return "send success";
    }
}
