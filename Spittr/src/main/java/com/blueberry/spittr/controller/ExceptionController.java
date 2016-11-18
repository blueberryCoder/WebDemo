package com.blueberry.spittr.controller;

import com.blueberry.spittr.exceptions.CatchException;
import com.blueberry.spittr.exceptions.SpittleNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 11/18/2016.
 */
@Controller
public class ExceptionController {

    @RequestMapping("/four")
    public void throwPageNotFoundException() {
        throw new SpittleNotFoundException();
    }

    @RequestMapping("/catchException")
    public void throwCatchException(){
        throw new CatchException();
    }

}
