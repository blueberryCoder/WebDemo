package com.blueberry.spittr.services;

import com.blueberry.spittr.beans.Spitter;

/**
 * Created by Administrator on 11/23/2016.
 */
public interface SpitterRepository {

    Spitter findByUsername(String username);

}
