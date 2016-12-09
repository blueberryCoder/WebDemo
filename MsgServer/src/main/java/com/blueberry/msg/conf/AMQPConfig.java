package com.blueberry.msg.conf;

import com.blueberry.msg.bean.Spitter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 12/8/2016.
 */
@Configuration
@ImportResource("classpath:/spring/amqpContext.xml")
public class AMQPConfig {

}
