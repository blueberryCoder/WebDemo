package com.blueberry.spittr.dao.impl;

import com.blueberry.spittr.beans.Spitter;
import com.blueberry.spittr.services.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 11/29/2016.
 */
@Repository
@Qualifier("jdbc")
public class JdbcSpitterRepository implements SpitterRepository {

    private JdbcOperations jdbcOperations;

    private static final String SELECT_SPITTER_BY_ID =
            "select * from Spitter where USERNAME=?";

    @Inject
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Spitter findByUsername(String username) {
//        return jdbcOperations.queryForObject(SELECT_SPITTER_BY_ID, (rs, rowNum) -> {
//            return new Spitter(rs.getLong("id"),
//                    rs.getString("username"),
//                    rs.getString("password"),
//                    rs.getString("firstName"),
//                    rs.getString("lastName"));
//        });

        return jdbcOperations.queryForObject(SELECT_SPITTER_BY_ID, this::mapSpitter,username);
    }

    private Spitter mapSpitter(ResultSet rs, int row) throws SQLException {
        return new Spitter(rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("firstName"),
                rs.getString("lastName"));
    }
}
