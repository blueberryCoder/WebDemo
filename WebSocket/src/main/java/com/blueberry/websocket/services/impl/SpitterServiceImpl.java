package com.blueberry.websocket.services.impl;

import com.blueberry.websocket.bean.Spitter;
import com.blueberry.websocket.services.SpitterServcie;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 12/12/2016.
 */
@Service
public class SpitterServiceImpl implements SpitterServcie {

    private SimpMessageSendingOperations messaging;

    //注入消息模板
    public SpitterServiceImpl(SimpMessageSendingOperations messaging) {
        this.messaging = messaging;
    }

    @Override
    public void broadcastSpitter(Spitter spitter) {
        // 发送消息
        messaging.convertAndSend("/topic/spitter", spitter);
    }
}
