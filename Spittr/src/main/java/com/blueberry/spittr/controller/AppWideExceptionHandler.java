package com.blueberry.spittr.controller;

import com.blueberry.spittr.exceptions.CatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 11/18/2016.
 */
@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(CatchException.class)
    @ResponseBody
    public String handleException(){
        return "处理了";
    }
}
