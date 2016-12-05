package com.blueberry.spittr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 12/5/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "spitter not found.")
public class SpitterNotFoundException extends RuntimeException {
    public SpitterNotFoundException(){
        super();
    }
    public SpitterNotFoundException(String message){
        super(message);
    }
}
