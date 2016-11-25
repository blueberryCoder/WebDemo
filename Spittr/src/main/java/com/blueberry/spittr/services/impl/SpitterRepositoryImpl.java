package com.blueberry.spittr.services.impl;

import com.blueberry.spittr.beans.Spitter;
import com.blueberry.spittr.services.SpitterRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 11/23/2016.
 */
@Repository("spitterRepository")
public class SpitterRepositoryImpl implements SpitterRepository {
    @Override
    public Spitter findByUsername(String username) {
        Spitter spitter = new Spitter();
//        spitter.setUsername("blueberry");
        spitter.setPassword("password");
        return spitter;
    }
}
