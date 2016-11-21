package com.blueberry.pizza.beans;

import java.io.Serializable;

/**
 * Created by Administrator on 11/21/2016.
 */
public class Pizza implements Serializable {
    private static final long serialVersionUID = 3770008314345287574L;

    private String type;

    public int size ;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
