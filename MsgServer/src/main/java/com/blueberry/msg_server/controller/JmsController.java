package com.blueberry.msg_server.controller;

import com.blueberry.msg_server.bean.Spitter;
import com.blueberry.msg_server.service.ReceiverService;
import com.blueberry.msg_server.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 12/6/2016.
 */
@Controller
@RequestMapping("/jms")
public class JmsController {

    @Autowired
    ReceiverService receiverService;

    @Autowired
    SendService sendService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    @ResponseBody
    public String send() {
        Spitter spitter = new Spitter();
        spitter.setUsername("username");
        spitter.setPassword("password");
        spitter.setFirstName("firstName");
        spitter.setLastName("lastName");
        sendService.send(spitter);
        return "发送成功";
    }

    @RequestMapping(value = "/receive",method = RequestMethod.GET)
    @ResponseBody
    public Spitter receive() {
        return receiverService.receive();
    }
}
