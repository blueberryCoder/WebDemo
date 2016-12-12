package com.blueberry.websocket;

import com.blueberry.websocket.conf.RootConfig;
import com.blueberry.websocket.conf.WebConfig;
import com.blueberry.websocket.conf.WebSocketConfig;
import com.blueberry.websocket.conf.WebSocketStompConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Administrator on 12/9/2016.
 */
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class,
//                WebSocketConfig.class
                WebSocketStompConfig.class

        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
