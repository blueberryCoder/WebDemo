package com.blueberry.weibo.user.bo.impl;

import com.blueberry.weibo.user.bean.User;
import com.blueberry.weibo.user.bo.UserBo;
import com.blueberry.weibo.user.dao.UserDao;
import com.blueberry.weibo.user.exceptions.LoginException;
import com.blueberry.weibo.user.exceptions.RegisterException;

/**
 * Created by Administrator on 2016/11/2.
 */
public class UserBoImpl implements UserBo {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {

        this.userDao = userDao;
    }

    public boolean register(User user) throws RegisterException {
        return userDao.register(user);
    }

    public boolean login(User user) throws LoginException {
        return userDao.login(user);
    }
}
