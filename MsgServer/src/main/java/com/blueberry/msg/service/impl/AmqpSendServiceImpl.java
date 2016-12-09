package com.blueberry.msg.service.impl;

import com.blueberry.msg.bean.Spitter;
import com.blueberry.msg.service.SendService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 12/6/2016.
 */
@Qualifier("amqp")
@Service
public class AmqpSendServiceImpl implements SendService {


    @Autowired
    AmqpTemplate amqpTemplate;
    @Override
    public void send(Spitter spitter) {
        amqpTemplate.convertAndSend(spitter);
    }
}
