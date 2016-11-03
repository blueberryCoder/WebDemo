package com.blueberry.weibo.user.exceptions;

import com.blueberry.weibo.exceptions.BaseException;

/**
 * Created by Administrator on 2016/11/3.
 */
public class LoginException extends BaseException {

    public static final int USER_NOT_EXIST =1;
    public static final int OTHER =2;
    public static final int PASSWORD_ERROR =3;

    public LoginException(int errorCode) {
        super(errorCode);
    }

    public LoginException(int errorCode, String message) {
        super(errorCode, message);
    }

    public LoginException(int errorCode, Throwable e) {
        super(errorCode, e);
    }

    public LoginException(int errorCode, String message, Throwable e) {
        super(errorCode, message, e);
    }
}
