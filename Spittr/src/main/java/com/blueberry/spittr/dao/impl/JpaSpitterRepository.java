package com.blueberry.spittr.dao.impl;

import com.blueberry.spittr.beans.Spitter;
import com.blueberry.spittr.beans.Spitter_;
import com.blueberry.spittr.services.SpitterRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by Administrator on 11/29/2016.
 */
@Repository
@Transactional
@Qualifier("jpa")
public class JpaSpitterRepository implements SpitterRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Spitter findByUsername(String username) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Spitter> query = cb.createQuery(Spitter.class);

        Root<Spitter> root = query.from(Spitter.class);
        query.select(root);

        Predicate userNameIs = cb.equal(root.get(Spitter_.username), username);
        query.where(userNameIs);

        TypedQuery<Spitter> typeQuery = em.createQuery(query);
        return typeQuery.getResultList().get(0);

    }
}
