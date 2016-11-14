package com.blueberry.spittr.services.impl;

import com.blueberry.spittr.beans.Spitter;
import com.blueberry.spittr.beans.Spittle;
import com.blueberry.spittr.services.SpittleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
@Repository
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {

        List<Spittle> list = new ArrayList<>();
        for(int i=0;i<count;i++){

            list.add(new Spittle("spitt"+i,new Date()));
        }

        return list;
    }

    @Override
    public void save(Spitter spittle) {
        //save
    }

    @Override
    public Spitter findByUsername(String username) {
        Spitter spitter  = new Spitter();
        spitter.setUsername("testUserName");
        return spitter;
    }
}
