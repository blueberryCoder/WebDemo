package com.blueberry.msg.listener;

import com.blueberry.msg.bean.Spitter;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 12/7/2016.
 */
public class SpitterAlterHandler {

    {
        logger.info("创建了SpitterAlterHandler");
    }
    private static Logger logger = Logger.getLogger(SpitterAlterHandler.class);

    public void handleSpitterAlter(Spitter spitter) {
        logger.info(ReflectionToStringBuilder.toString(spitter));
    }
}
