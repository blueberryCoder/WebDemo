package com.blueberry.weibo.user.dao;

import com.blueberry.weibo.user.bean.User;
import com.blueberry.weibo.user.exceptions.LoginException;
import com.blueberry.weibo.user.exceptions.RegisterException;

/**
 * Created by Administrator on 2016/11/2.
 */
public interface UserDao {

    boolean register(User user) throws RegisterException;

    boolean login(User user) throws LoginException;
}
