package com.blueberry.pizza.beans;

import java.io.Serializable;

/**
 * Created by Administrator on 11/21/2016.
 */
public class Payment implements Serializable{
    public String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "type='" + type + '\'' +
                '}';
    }
}
