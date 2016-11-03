package com.blueberry.weibo.utils;

/**
 * Created by Administrator on 2016/11/3.
 */
public final class StringUtil {
    private StringUtil() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static boolean isEmpty(CharSequence sequence) {
        return sequence == null || sequence.length() == 0;
    }
}
