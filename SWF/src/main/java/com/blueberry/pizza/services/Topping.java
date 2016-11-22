package com.blueberry.pizza.services;

import sun.nio.cs.ISO_8859_2;

import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by Administrator on 11/21/2016.
 */
public class Topping {
    private static List<String> sets = new ArrayList<>();

    static {
        sets.add("苹果");
        sets.add("香蕉");
        sets.add("梨");
    }

    public static List<String> asList() {
        return sets;
    }
}
