package com.blueberry.weibo.user.enums;

/**
 * Created by Administrator on 2016/11/2.
 */
public enum UserType {

    ADMIN(0), USER(1);

    private int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
