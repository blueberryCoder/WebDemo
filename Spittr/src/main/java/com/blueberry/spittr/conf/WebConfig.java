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
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.webflow.context.ExternalContext;
import org.springframework.webflow.core.FlowException;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.executor.FlowExecutionResult;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.blueberry.spittr")
public class WebConfig extends WebMvcConfigurerAdapter {

    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        MappingJackson2HttpMessageConverter converter=
                new MappingJackson2HttpMessageConverter();
        return converter;
    }

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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/res/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(31556926);
    }

//    @Bean
//    public ViewResolver cnViewResolver(ContentNegotiationManager manager) {
//        ContentNegotiatingViewResolver contentNegotiatingViewResolver=
//                new ContentNegotiatingViewResolver();
//        contentNegotiatingViewResolver.setContentNegotiationManager(manager);
//        return contentNegotiatingViewResolver;
//    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(mappingJackson2HttpMessageConverter());
    }
}
