package com.blueberry.spittr.controller;

import com.blueberry.spittr.beans.Spitter;

import com.blueberry.spittr.services.SpittleRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Administrator on 2016/11/14.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private Logger logger = Logger.getLogger(SpitterController.class);

    @Autowired
    private SpittleRepository spittleRepository;

    public void setSpittleRepository(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(Model model, @Valid Spitter spitter, Errors errors) {
        if(errors.hasErrors()){
            return "registerForm";
        }
        spittleRepository.save(spitter);
        //通过url模板进行重定向
        model.addAttribute("username",spitter.getUsername());
        return "redirect:/spitter/{username}";
    }

    @RequestMapping(value = "/{username}")
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = spittleRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }
}
