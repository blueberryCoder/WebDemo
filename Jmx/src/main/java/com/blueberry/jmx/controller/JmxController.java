package com.blueberry.jmx.controller;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 12/14/2016.
 */
@Controller
@ManagedResource(objectName = "spitter:name=JmxController")
public class JmxController {

    public static final int DEFAULT_COUNT = 25;

    private int count = DEFAULT_COUNT;

    public String other() {
        return "other message.";
    }

    @ManagedAttribute
    public int getCount() {
        return count;
    }

    @ManagedAttribute
    public void setCount(int count) {
        this.count = count;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/count")
    @ResponseBody
    public String count() {
        return String.valueOf(count);
    }
}
