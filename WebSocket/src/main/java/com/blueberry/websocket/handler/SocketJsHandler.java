package com.blueberry.websocket.handler;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by Administrator on 12/9/2016.
 */
public class SocketJsHandler extends TextWebSocketHandler {
    private Logger logger = Logger.getLogger(SocketJsHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("after established.");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("after close");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("receive:"+ReflectionToStringBuilder.toString(message));
        Thread.sleep(2000);
        session.sendMessage(new TextMessage("come from server"));
    }
}
