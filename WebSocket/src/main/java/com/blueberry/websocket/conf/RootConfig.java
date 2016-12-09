package com.blueberry.websocket.conf;

import org.jboss.logging.Field;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Administrator on 12/9/2016.
 */
@Configuration
@ComponentScan(basePackages = "com.blueberry.websocket", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION ,value = EnableWebMvc.class)
})
public class RootConfig {

}
