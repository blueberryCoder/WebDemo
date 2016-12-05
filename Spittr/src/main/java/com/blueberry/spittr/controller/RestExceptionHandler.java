package com.blueberry.spittr.controller;

import com.blueberry.spittr.beans.Error;
import com.blueberry.spittr.exceptions.CatchException;
import com.blueberry.spittr.exceptions.SpitterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Administrator on 12/5/2016.
 */
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(SpitterNotFoundException.class)
    public ResponseEntity<Error> handler(SpitterNotFoundException e) {
        Error error = new Error(e.getMessage(), 4);
        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }
}
