package com.blueberry.spittr.services.impl;

import com.blueberry.spittr.beans.Spitter;
import com.blueberry.spittr.services.SpitterService;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 12/1/2016.
 */
@Component
public class SpitterServiceImpl implements SpitterService {

    private static Logger logger = LoggerFactory.getLogger(SpitterServiceImpl.class);

    @Override
    public Spitter getSpitter() {
        Spitter spitter = new Spitter();
        spitter.setUsername("blueberry");
        logger.info(ReflectionToStringBuilder.toString(spitter));
        return spitter;
    }

    @Override
    public void deleteSpitter(long id) {
        logger.info("delete:" + id);
    }
}
