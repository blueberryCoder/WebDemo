package com.blueberry.spittr.beans;

/**
 * Created by Administrator on 12/5/2016.
 */
public class Error {
    private int code;
    private String message;

    public Error(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public Error() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
