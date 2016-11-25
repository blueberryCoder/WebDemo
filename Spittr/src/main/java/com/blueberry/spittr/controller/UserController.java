package com.blueberry.spittr.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 11/25/2016.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String loginOut() {
        return "loginOut";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show() {
        return "show";
    }
}
