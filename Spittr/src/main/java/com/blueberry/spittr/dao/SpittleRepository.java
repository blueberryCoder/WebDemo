package com.blueberry.spittr.dao;

import com.blueberry.spittr.beans.Spitter;

import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */

public interface SpittleRepository {

    void save(Spitter spittle);

    Spitter findByUsername(String username);
}
