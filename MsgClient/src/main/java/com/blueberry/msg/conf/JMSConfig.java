package com.blueberry.msg.conf;

import com.blueberry.msg.bean.Spitter;
import com.blueberry.msg.service.JmsService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.remoting.JmsInvokerClientInterceptor;
import org.springframework.jms.remoting.JmsInvokerProxyFactoryBean;
import org.springframework.jms.remoting.JmsInvokerServiceExporter;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import javax.jms.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 12/6/2016.
 */
@Configuration
@ImportResource("classpath:/spring/appContext.xml")

public class JMSConfig {

    /**
     * 创建连接工厂
     *
     * @return {@link ActiveMQConnectionFactory}
     */
    @Bean
    public ConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://localhost:61616");
        return connectionFactory;
    }

    /**
     * 定义了一个ActiveMQ队列
     *
     * @return
     */
    @Bean
    public ActiveMQQueue activeMQQueue() {
        ActiveMQQueue activeMQQueue = new ActiveMQQueue("spitter.queue");

        return activeMQQueue;
    }

    /**
     * 定义了一个ActiveMQ主题
     *
     * @return
     */
    @Bean
    public ActiveMQTopic activeMQTopic() {
        ActiveMQTopic activeMQTopic = new ActiveMQTopic("spitter.topic");
        return activeMQTopic;
    }

    @Bean
    public JmsOperations jmsTemplate(MappingJackson2MessageConverter converter,
                                     ConnectionFactory connectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        //设置默认目的地
        jmsTemplate.setDefaultDestinationName("spitter.queue");
        jmsTemplate.setMessageConverter(converter);
        jmsTemplate.setConnectionFactory(connectionFactory);
        return jmsTemplate;
    }

    @Bean
    public MappingJackson2MessageConverter mappingJackson2MessageConverter(){
        MappingJackson2MessageConverter mappingJackson2MessageConverter =
                new MappingJackson2MessageConverter();
        Map<String,Class<?>> map = new HashMap<String,Class<?>>();
        map.put("type",Spitter.class);
        mappingJackson2MessageConverter.setTypeIdMappings(map);
        mappingJackson2MessageConverter.setTypeIdPropertyName("type");
        return mappingJackson2MessageConverter;
    }

//    @Bean
//    public MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory,
//                                                             MappingJackson2MessageConverter
//                                                                     mappingJackson2MessageConverter,
//                                                             MessageListener messageListener){
//        DefaultMessageListenerContainer messageListenerContainer =
//                new DefaultMessageListenerContainer();
//        messageListenerContainer.setConnectionFactory(connectionFactory);
//        messageListenerContainer.setMessageConverter(mappingJackson2MessageConverter);
//        messageListenerContainer.setMessageListener(messageListener);
//        messageListenerContainer.setDestinationName("spitter.queue");
//
//        return messageListenerContainer;
//    }

//
//    /**
//     * 导出基于jms的服务
//     * @param jmsService
//     * @return
//     */
//    @Bean
//    public JmsInvokerServiceExporter jmsInvokerServiceExporter(JmsService jmsService){
//        JmsInvokerServiceExporter jmsInvokerServiceExporter = new JmsInvokerServiceExporter();
//        jmsInvokerServiceExporter.setService(jmsService);
//        jmsInvokerServiceExporter.setServiceInterface(JmsService.class);
//        return jmsInvokerServiceExporter;
//    }

    /**
     * 使用jms的服务
     * @param connectionFactory
     * @return
     */
    @Bean
    public JmsInvokerProxyFactoryBean jmsInvokerClientInterceptor(ConnectionFactory connectionFactory){
        JmsInvokerProxyFactoryBean jmsInvokerProxyFactoryBean = new JmsInvokerProxyFactoryBean();
        jmsInvokerProxyFactoryBean.setConnectionFactory(connectionFactory);
        jmsInvokerProxyFactoryBean.setServiceInterface(JmsService.class);
        jmsInvokerProxyFactoryBean.setQueueName("spitter.queue");
        return jmsInvokerProxyFactoryBean;
    }


}
