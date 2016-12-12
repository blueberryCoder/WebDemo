package com.blueberry.websocket.controller;

import com.blueberry.websocket.bean.Shout;
import com.blueberry.websocket.bean.Spitter;
import com.blueberry.websocket.exceptions.SpitterException;
import com.blueberry.websocket.services.impl.SpitterServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Administrator on 12/12/2016.
 */
@Controller
public class MarcoController {

    private static final Logger logger = Logger.getLogger(MarcoController.class);

    @Autowired
    private SpitterServiceImpl spitterService;

    @RequestMapping(method = RequestMethod.GET,value = "/send")
    @ResponseBody
    public String send(){
        Spitter spitter = new Spitter();
        spitter.setUsername("username");
        spitter.setFirstName("firstName");
        spitter.setLastName("lastName");
        spitter.setPassword("password");
        spitterService.broadcastSpitter(spitter);
        return "send success!!";
    }

    @MessageExceptionHandler(SpitterException.class)
    @SendTo("/queue/errors")
    public SpitterException handleException(SpitterException e){
        logger.info(e.getMessage());
        return e;
    }


    @MessageMapping("/marco") //处理发往 "/app/marco"目的地的消息
    @SendTo("/topic/marco")
    public Shout handleShout(Shout shout) throws InterruptedException {
        logger.info("Received message: " + shout.getMessage());
        Thread.sleep(1000);
        Shout sh = new Shout();
        if(shout.getMessage().equals("error")){
            throw new SpitterException("error");
        }
        sh.setMessage("from server.");
        return sh;
    }

//    @SubscribeMapping("/marco")
//    public Shout handleSubscription() throws InterruptedException {
//        Shout shout = new Shout();
//        shout.setMessage("Pojo");
//        logger.info("handleSubscription");
//        Thread.sleep(1000);
//
//        return shout;
//    }
}
