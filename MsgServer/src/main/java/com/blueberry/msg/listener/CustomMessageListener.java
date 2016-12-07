package com.blueberry.msg.listener;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by Administrator on 12/7/2016.
 */
@Component
public class CustomMessageListener implements MessageListener {

    private Logger logger = Logger.getLogger(CustomMessageListener.class);
    @Override
    public void onMessage(Message message) {
        logger.info(ReflectionToStringBuilder.toString(message));
    }
}
