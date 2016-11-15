package com.blueberry.spittr.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Administrator on 11/15/2016.
 */
@Component
@Configuration
public class JspConfig {

    /**
     * 返回一个将视图解析为Web应用的内部资源（一般为JSP）的视图解析器。
     *
     * @return 返回{@link InternalResourceViewResolver}
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        //设置可以在JSP页面中通过${}访问容器中的bean
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

}
