package com.blueberry.spittr.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * Created by Administrator on 12/5/2016.
 * ContentNegotiating在WebConfig里面配置。
 */
@Component
@Configuration
public class NegotiatingConfig {



    @Bean
    public ViewResolver beanNameViewResolver(){
        return new BeanNameViewResolver();
    }

    @Bean
    public View spitter(){
        return new MappingJackson2JsonView();
    }


}
