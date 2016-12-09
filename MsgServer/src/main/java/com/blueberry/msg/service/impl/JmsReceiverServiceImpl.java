package com.blueberry.msg.service.impl;

import com.blueberry.msg.bean.Spitter;
import com.blueberry.msg.service.ReceiverService;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 12/6/2016.
 */
@Qualifier("jms")
@Service
public class JmsReceiverServiceImpl implements ReceiverService {

    private Logger logger = Logger.getLogger(JmsReceiverServiceImpl.class);

    @Autowired
    private JmsOperations jmsOperations;


    @Override
    public Spitter receive() {
        Spitter spitter= (Spitter) jmsOperations.receiveAndConvert();
        logger.info(ReflectionToStringBuilder.toString(spitter));
        return spitter;
    }
}
