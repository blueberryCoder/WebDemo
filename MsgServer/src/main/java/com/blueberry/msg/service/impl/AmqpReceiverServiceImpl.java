package com.blueberry.msg.service.impl;

import com.blueberry.msg.bean.Spitter;
import com.blueberry.msg.service.ReceiverService;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
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
public class AmqpReceiverServiceImpl implements ReceiverService {


    private Logger logger = Logger.getLogger(AmqpReceiverServiceImpl.class);

    @Autowired
    private AmqpTemplate amqpTemplate;


    @Override
    public Spitter receive() {
        Spitter spitter= (Spitter) amqpTemplate.receiveAndConvert("spitter.queue.1");
        logger.info(ReflectionToStringBuilder.toString(spitter));
        return spitter;
    }
}
