package com.blueberry.pizza.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 11/21/2016.
 */
public class Pizza implements Serializable {
    private static final long serialVersionUID = 3770008314345287574L;

    private List<String> topping;

    public String size ;

    public List<String> getTopping() {
        return topping;
    }

    public void setTopping(List<String> topping) {
        this.topping = topping;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
