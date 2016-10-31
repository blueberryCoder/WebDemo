package com.blueberry.ssh.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;


/**
 * Created by Administrator on 2016/10/31.
 */
public class ErrorAction extends ActionSupport {

    private static final Logger logger = Logger.getLogger(ErrorAction.class);
    @Override
    public String execute() throws Exception {

        if(logger.isDebugEnabled()){
            logger.debug("execute()!");
        }
        logger.error("This is Error message",new Exception("Testing"));
        return SUCCESS;
    }
}
