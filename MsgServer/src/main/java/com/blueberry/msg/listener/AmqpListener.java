package com.blueberry.msg.listener;

import com.blueberry.msg.bean.Spitter;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 12/9/2016.
 */
public class AmqpListener  {
    private Logger logger = Logger.getLogger(AmqpListener.class);

    public void handle(Spitter spitter) {
        logger.info(ReflectionToStringBuilder.toString(spitter));
    }


}
