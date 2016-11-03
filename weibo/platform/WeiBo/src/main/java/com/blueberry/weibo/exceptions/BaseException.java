package com.blueberry.weibo.exceptions;

/**
 * Created by Administrator on 2016/11/3.
 */
public abstract class BaseException extends RuntimeException {

    protected int errorCode;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public BaseException(int errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public BaseException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BaseException(int errorCode,Throwable e){
        super(e);
        this.errorCode = errorCode;
    }

    public BaseException(int errorCode,String message,Throwable e){
        super(message,e);
        this.errorCode = errorCode;
    }


}
