package com.blueberry.spittr.dao;

import com.blueberry.spittr.beans.Spitter;

/**
 * Created by Administrator on 11/23/2016.
 */
public interface SpitterRepository {

    Spitter findByUsername(String username);

}
