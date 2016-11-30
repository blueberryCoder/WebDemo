package com.blueberry.spittr.dao.impl;

import com.blueberry.spittr.beans.Spitter;
import com.blueberry.spittr.dao.SpitterSweeper;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Administrator on 11/30/2016.
 */
public class SpittleRepositoryImpl implements SpitterSweeper {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Spitter addSpitter(Spitter spitter) {
        em.persist(spitter);
        return spitter;
    }
}
