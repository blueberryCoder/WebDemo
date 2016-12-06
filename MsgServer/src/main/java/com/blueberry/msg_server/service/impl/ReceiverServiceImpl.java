package com.blueberry.msg_server.service.impl;

import com.blueberry.msg_server.bean.Spitter;
import com.blueberry.msg_server.service.ReceiverService;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

/**
 * Created by Administrator on 12/6/2016.
 */
@Service
public class ReceiverServiceImpl implements ReceiverService {

    private Logger logger = Logger.getLogger(ReceiverServiceImpl.class);

    @Autowired
    private JmsOperations jmsOperations;


    @Override
    public Spitter receive() {
//        Spitter spitter = (Spitter) jmsOperations.receiveAndConvert();
//        Message receive = jmsOperations.receive();
//        logger.info(ReflectionToStringBuilder.toString(receive));
        Spitter spitter =null;
//        Message receive = jmsOperations.receive();
//        logger.info(ReflectionToStringBuilder.toString(receive));
        spitter= (Spitter) jmsOperations.receiveAndConvert();
        logger.info(ReflectionToStringBuilder.toString(spitter));


        return spitter;
    }
}
