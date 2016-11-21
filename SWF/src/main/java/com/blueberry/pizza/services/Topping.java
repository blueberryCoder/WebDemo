package com.blueberry.pizza.services;

import java.util.*;

/**
 * Created by Administrator on 11/21/2016.
 */
public class Topping {
    private List<String> sets = new ArrayList<>();

    {
        sets.add("苹果");
        sets.add("香蕉");
        sets.add("梨");
    }

    public List<String> asList() {
        return sets;
    }
}
