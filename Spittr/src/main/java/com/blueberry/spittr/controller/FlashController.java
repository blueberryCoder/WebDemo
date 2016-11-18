package com.blueberry.spittr.controller;

import com.blueberry.spittr.beans.Spitter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Administrator on 11/18/2016.
 */
@Controller
public class FlashController {

    @RequestMapping(value = "/flash",method = RequestMethod.POST)
    public String flashAttribute(Spitter spitter, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("spitter",spitter);
        return "redirect:/out";
    }

    @RequestMapping(value = "/flash",method = RequestMethod.GET)
    public String flashAttribute(RedirectAttributes redirectAttributes){
        return "flash";
    }

    @ResponseBody
    @RequestMapping(value = "/out",method = RequestMethod.GET)
    public String out(RedirectAttributes redirectAttributes){
        Spitter spitter = (Spitter) redirectAttributes.getFlashAttributes().get("spitter");
        return spitter.getUsername();
    };
}
