package com.blueberry.spittr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 11/17/2016.
 */
@RequestMapping(value = "/thymeleaf")
@Controller
public class ThymeleafController {

    @RequestMapping("home")
    public String home() {
        return "home";
    }

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
}
