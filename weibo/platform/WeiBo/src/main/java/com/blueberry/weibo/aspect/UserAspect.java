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

    @Pointcut(" execution (* com.blueberry.weibo.user.dao.impl.UserDaoImpl.register(com.blueberry.weibo.user.bean.User)) && args(u)")
    public void resisterUser(User u) {
    }

    @Before("resisterUser(u)")
    public void beforeRegisterUser(User u) {

        LOG.info("beforeRegisterUser,user.username:" + u.getName());
    }

    @After("resisterUser(u)")
    public void afterRegisterUser(User u) {
        LOG.info("afterRegister,user.username:" + u.getName());
    }
}
