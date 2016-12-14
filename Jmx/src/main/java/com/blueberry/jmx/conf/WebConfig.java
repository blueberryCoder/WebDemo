package com.blueberry.jmx.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 12/14/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "com.blueberry.jmx")
public class WebConfig extends WebMvcConfigurerAdapter{
}
