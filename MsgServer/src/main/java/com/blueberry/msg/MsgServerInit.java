package com.blueberry.msg;


import com.blueberry.msg.conf.JMSConfig;
import com.blueberry.msg.conf.JspConfig;
import com.blueberry.msg.conf.RootConfig;
import com.blueberry.msg.conf.WebConfig;
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