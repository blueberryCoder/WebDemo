package com.blueberry.weibo.aspect;


import com.blueberry.weibo.user.bean.User;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/8.
 */
@Component("userAspect")
@Aspect
public class UserAspect {

    private static Logger LOG = Logger.getLogger(UserAspect.class);

    @Pointcut(" execution (* com.blueberry.weibo.user.dao.impl.UserDaoImpl.register(..))")
    public void resisterUser() {
    }

    @Before("resisterUser()")
    public void beforeRegisterUser() {
        LOG.info("beforeRegisterUser,user.username:" );
    }

    @After("resisterUser()")
    public void afterRegisterUser() {
        LOG.info("afterRegister,user.username:");
    }
}
