package com.blueberry.spittr.services;

import com.blueberry.spittr.beans.Spitter;

import java.util.List;

/**
 * Created by Administrator on 12/1/2016.
 * <p>
 * 测试 RPC
 */
public interface SpitterService {
    Spitter getSpitter();

    void deleteSpitter(long id);
}
