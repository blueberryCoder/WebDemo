package com.blueberry.spittr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 11/15/2016.
 */
@RequestMapping(value = "/tiles")
@Controller
public class TileController {

    @RequestMapping("home")
    public String home() {
        return "home";
    }
}
