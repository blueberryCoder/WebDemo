package com.blueberry.spittr.controller;

import com.blueberry.spittr.services.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/11/9.
 */
@Controller
public class HomeController {

//    @Autowired
//    private SpittleRepository spittleRepository;
//
//    public void setSpittleRepository(SpittleRepository spittleRepository) {
//        this.spittleRepository = spittleRepository;
//    }
//
//    @RequestMapping(value = "/",method = RequestMethod.GET)
//    public String home(Model model) {
//        model.addAttribute("spittrList",spittleRepository.findSpittles(Long.MAX_VALUE,20));
//        return "home";
//    }
}
