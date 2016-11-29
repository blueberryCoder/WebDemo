package com.blueberry.spittr.dao.impl;

import com.blueberry.spittr.beans.Spitter;
import com.blueberry.spittr.services.SpitterRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.criteria.internal.CriteriaDeleteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 11/29/2016.
 */
@Repository
@Qualifier("hibernate")
@Primary
public class HibernateSpitterRepository implements SpitterRepository {

//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public HibernateSpitterRepository(SessionFactory sessionFactory) {
//
//        this.sessionFactory = sessionFactory;
//    }
//
//    private Session currentSession() {
//        return sessionFactory.openSession();
//    }

    public long count() {
        return findAll().size();
    }

    public Spitter save(Spitter spitter) {
//        Serializable id = currentSession().save(spitter);
//        return new Spitter((Long) id,
//                spitter.getUsername(),
//                spitter.getPassword(),
//                spitter.getFirstName(),
//                spitter.getLastName());
        return null;
    }

    public Spitter findOne(long id) {
//        return (Spitter) currentSession().get(Spitter.class, id);
        return null;
    }

    @Override
    public Spitter findByUsername(String username) {
//        return (Spitter) currentSession()
//                .createCriteria(Spitter.class)
//                .add(Restrictions.eq("username", username))
//                .list().get(0);
        return null;
    }

    public List<Spitter> findAll() {
//        return currentSession()
//                .createCriteria(Spitter.class).list();
        return  null;
    }
}
