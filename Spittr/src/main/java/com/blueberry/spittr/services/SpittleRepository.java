package com.blueberry.spittr.services;

import com.blueberry.spittr.beans.Spitter;
import com.blueberry.spittr.beans.Spittle;

import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    void save(Spitter spittle);

    Spitter findByUsername(String username);
}
