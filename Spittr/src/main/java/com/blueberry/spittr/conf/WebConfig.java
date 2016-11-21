package com.blueberry.spittr.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.webflow.context.ExternalContext;
import org.springframework.webflow.core.FlowException;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.executor.FlowExecutionResult;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2016/11/9.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.blueberry.spittr")
@ImportResource("classpath:/spring/flow-config.xml")
public class WebConfig extends WebMvcConfigurerAdapter {


    /**
     * 国际化资源文件,实现可以是{@link ResourceBundleMessageSource},
     * {@link org.springframework.context.support.ReloadableResourceBundleMessageSource}。
     *
     * @return {@link MessageSource}
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource =
                new ResourceBundleMessageSource();
        messageSource.setBasename("message");
        messageSource.setDefaultEncoding("utf-8");
        return messageSource;
    }

    /**
     * StandardServletMultipartResolver 依赖于Servlet3.0对multipart请求的支持。
     * org.springframework.web.multipart.commons.CommonsMultipartResolver 依赖于Jakarta Commons FileUpload
     * 解析multipart请求。
     *
     * @return {@link StandardServletMultipartResolver} ,
     * {@link org.springframework.web.multipart.commons.CommonsMultipartResolver}
     */
    @Bean
    public MultipartResolver multipartResolver() throws IOException {
//        CommonsMultipartResolver multipartResolver =
//                new CommonsMultipartResolver();
//        multipartResolver.setUploadTempDir(new FileSystemResource("/temp/spittr/uploads"));
        new FlowHandlerAdapter().setFlowExecutor(new FlowExecutor() {
            @Override
            public FlowExecutionResult launchExecution(String s, MutableAttributeMap<?> mutableAttributeMap, ExternalContext externalContext) throws FlowException {
                return null;
            }

            @Override
            public FlowExecutionResult resumeExecution(String s, ExternalContext externalContext) throws FlowException {
                return null;
            }
        });
        return new StandardServletMultipartResolver();
    }


    /**
     * 解决中文乱码问题。
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new StringHttpMessageConverter(Charset.forName("utf-8")));
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
