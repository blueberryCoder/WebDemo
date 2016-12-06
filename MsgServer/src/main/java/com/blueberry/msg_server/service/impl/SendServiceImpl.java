package com.blueberry.msg_server.service.impl;

import com.blueberry.msg_server.bean.Spitter;
import com.blueberry.msg_server.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;

/**
 * Created by Administrator on 12/6/2016.
 */
@Service
public class SendServiceImpl implements SendService {

    @Autowired
    JmsOperations jmsOperations;
    @Override
    public void send(Spitter spitter) {
        jmsOperations.convertAndSend(spitter);
    }
}
