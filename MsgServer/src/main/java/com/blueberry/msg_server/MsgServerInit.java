package com.blueberry.msg_server;


import com.blueberry.msg_server.conf.JMSConfig;
import com.blueberry.msg_server.conf.JspConfig;
import com.blueberry.msg_server.conf.RootConfig;
import com.blueberry.msg_server.conf.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MsgServerInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class, JMSConfig.class, JspConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}