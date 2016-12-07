package com.blueberry.msg.conf;

import com.blueberry.msg.bean.Spitter;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;
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
        Map<String,Class<?>> map = new HashMap<>();
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

}
