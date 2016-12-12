package com.blueberry.websocket.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import java.util.List;

/**
 * Created by Administrator on 12/12/2016.
 */
@Configuration
//这个注解不仅配置了WebSocket,还配置了基于代理的STOMP消息。
@EnableWebSocketMessageBroker
public class WebSocketStompConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //将 "/marcopolo" 注册为STOMP端点
        registry.addEndpoint("/marcopolo").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 消息代理会处理前缀为 "/topic"、"/queue"的消息。如果不重写它。将会自动配置一个简单的内存消息代理，
        // 它用来处理以"/topic"为前缀的消息。
//        registry.enableSimpleBroker("/queue", "/topic");

        //可以设置代理中继，（ActiveMQ,RabbitMQ等）
        // rabbimq-plugins enable rabbitmq_stomp 启动rabbitmq_stomp插件

        registry.enableStompBrokerRelay("/topic","/queue")
                .setRelayHost("localhost")
                .setRelayPort(61613) //默认端口也是61613
                .setClientLogin("guest")
                .setClientPasscode("guest");

        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
//        messageConverters.add(new MappingJackson2MessageConverter());
        return super.configureMessageConverters(messageConverters);
    }
}
