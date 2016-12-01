package com.blueberry.spittr.services;

import com.blueberry.spittr.beans.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * Created by Administrator on 12/1/2016.
 */
@Component
@WebService(serviceName = "SpitterService")
public class SpitterServiceEndpoint {

    @Autowired
    SpitterService spitterService;

    public Spitter getSpitter() {
        return spitterService.getSpitter();
    }

    public void deleteSpitter(long id) {
        spitterService.deleteSpitter(id);
    }
}
