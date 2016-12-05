package com.blueberry.spittr.controller;


import com.blueberry.spittr.beans.Spitter;
import com.blueberry.spittr.exceptions.SpitterNotFoundException;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URL;


/**
 * Created by Administrator on 12/5/2016.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
//
//    @RequestMapping(value = "/negotiating",method = RequestMethod.GET)
//    public String home(Model model){
//        Spitter spitter = new Spitter();
//        spitter.setUsername("blueberry");
//        spitter.setPassword("password");
//        spitter.setFirstName("firstName");
//        spitter.setLastName("lastName");
//        model.addAttribute(spitter);
//        return  "spitter";
//    }

    public Logger logger = Logger.getLogger(RestController.class);

    @RequestMapping(value = "/spitter", method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Spitter> getSpitter(@RequestBody Spitter sp,
                                              UriComponentsBuilder ucb) {
        logger.info(ReflectionToStringBuilder.toString(sp   ));
        if(sp.getId().intValue()==0){
            throw new SpitterNotFoundException("not found");
        }
        Spitter spitter = new Spitter();
        spitter.setUsername("username");
        spitter.setPassword("password");
        spitter.setFirstName("firstName");
        spitter.setLastName("lastName");


        //添加其他信息
        HttpHeaders headers = new HttpHeaders();
        URI locationUrl = ucb.path("/spitters")
                .path("/hhhh").build().toUri();
        headers.setLocation(locationUrl);
        headers.setLastModified(System.currentTimeMillis());
        ResponseEntity<Spitter> spitterResponseEntity =
                new ResponseEntity<Spitter>(spitter,headers,HttpStatus.CREATED);
        return spitterResponseEntity;
    }
}
