package com.blueberry.weibo.user.exceptions;

import com.blueberry.weibo.exceptions.BaseException;

/**
 * Created by Administrator on 2016/11/3.
 */
public class RegisterException extends BaseException {

    public static final int USER_EXIST = 1;

    public static final int OTHER = 2;


    public RegisterException(int errorCode) {
        super(errorCode);
    }

    public RegisterException(int errorCode, String message) {
        super(errorCode, message);
    }

    public RegisterException(int errorCode, String message, Throwable e) {
        super(errorCode, message, e);
    }
}
