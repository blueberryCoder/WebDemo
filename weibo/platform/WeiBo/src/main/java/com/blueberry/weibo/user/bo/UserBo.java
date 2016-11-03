package com.blueberry.weibo.user.bo;

import com.blueberry.weibo.user.bean.User;
import com.blueberry.weibo.user.exceptions.LoginException;
import com.blueberry.weibo.user.exceptions.RegisterException;

/**
 * Created by Administrator on 2016/11/2.
 */
public interface UserBo {
    boolean register(User user) throws RegisterException;

    boolean login(User user) throws LoginException;
}
