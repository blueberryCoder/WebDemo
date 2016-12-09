package com.blueberry.msg.controller;

import com.blueberry.msg.bean.Spitter;
import com.blueberry.msg.service.JmsService;
import com.blueberry.msg.service.ReceiverService;
import com.blueberry.msg.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.remoting.JmsInvokerClientInterceptor;
import org.springframework.jms.remoting.JmsInvokerProxyFactoryBean;
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


    @Autowired
    JmsService jmsService;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
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


    /**
     * 测试这个的时候需要取消监听器。
     *
     * @return
     */
    @RequestMapping(value = "/receive", method = RequestMethod.GET)
    @ResponseBody
    public Spitter receive() {
        return receiverService.receive();
    }

    @RequestMapping(value = "/call",method = RequestMethod.GET)
    @ResponseBody
    public String callRpcService(){
        Spitter spitter = new Spitter();
        spitter.setUsername("username");
        spitter.setPassword("password");
        spitter.setFirstName("firstName");
        spitter.setLastName("lastName");
        jmsService.sendSpitter(spitter);
        return "调用成功";
    }

}
