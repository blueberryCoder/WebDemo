package com.blueberry.weibo.common;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2016/11/9.
 */
public class DefaultExtendable implements Extendable {

    private Logger logger = Logger.getLogger(DefaultExtendable.class);

    @Override
    public void extend() {
        logger.info("默认的扩展方法");
    }
}
