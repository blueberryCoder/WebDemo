package com.blueberry.weibo.common;

import com.blueberry.weibo.utils.RSAUtils;

import java.util.Map;

/**
 * Created by Administrator on 2016/11/4.
 */
public final class SecretHolder {

    private static Map<String, Object> keys;

    static {
        try {
            keys = RSAUtils.genKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private SecretHolder() {
    }


    public static String getPublicKey() throws Exception {
        return RSAUtils.getPublicKey(keys);
    }

    public static String getPrivateKey() throws Exception {
        return RSAUtils.getPrivateKey(keys);
    }

}
