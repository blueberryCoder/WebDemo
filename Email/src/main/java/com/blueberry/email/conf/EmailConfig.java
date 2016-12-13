package com.blueberry.email.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by Administrator on 12/13/2016.
 */
@Configuration
@PropertySource("classpath:/conf/mail.properties")
public class EmailConfig {

    @Autowired
    Environment env;

    @Bean
    public JavaMailSender mailSender(Environment env){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("mailserver.host"));
        mailSender.setUsername(env.getProperty("mailserver.username"));
        mailSender.setPassword(env.getProperty("mailserver.password"));
        mailSender.setPort(Integer.parseInt(env.getProperty("mailserver.port")));

        Properties properties=new Properties();
        properties.put("mail.debug",true);
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.ssl.enable",true);
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.timeout",25000);
        mailSender.setJavaMailProperties(properties);


        return mailSender;
    }
}
