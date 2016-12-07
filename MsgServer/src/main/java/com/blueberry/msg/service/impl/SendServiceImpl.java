package com.blueberry.msg.service.impl;

import com.blueberry.msg.bean.Spitter;
import com.blueberry.msg.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

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
