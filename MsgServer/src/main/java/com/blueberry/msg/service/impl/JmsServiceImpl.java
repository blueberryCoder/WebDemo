package com.blueberry.msg.service.impl;

import com.blueberry.msg.bean.Spitter;
import com.blueberry.msg.service.JmsService;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 12/7/2016.
 */
@Component
public class JmsServiceImpl implements JmsService {

    private Logger logger = Logger.getLogger(JmsServiceImpl.class);

    @Override
    public void sendSpitter( Spitter spitter) {
        logger.info(ReflectionToStringBuilder.toString(spitter));
    }
}
