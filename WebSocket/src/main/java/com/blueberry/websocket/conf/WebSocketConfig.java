package com.blueberry.websocket.conf;


import com.blueberry.websocket.handler.MarcoHandler;
import com.blueberry.websocket.handler.SocketJsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by Administrator on 12/9/2016.
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(marcoHandler(), "/marco");
        registry.addHandler(socketJsHandler(),"/socketJS").withSockJS();
    }

    @Bean
    SocketJsHandler socketJsHandler(){
        return new SocketJsHandler();
    }
    @Bean
    public MarcoHandler marcoHandler() {
        return new MarcoHandler();
    }

}
