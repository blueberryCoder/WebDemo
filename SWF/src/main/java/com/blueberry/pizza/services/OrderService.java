package com.blueberry.pizza.services;

import com.blueberry.pizza.beans.Order;
import com.blueberry.pizza.beans.Pizza;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/21/2016.
 */
@Service
public class OrderService {
    public void addPizza(Order order , Pizza pizza){
//
//        if(pizza!=null && pizza.getTopping()!=null){
//            List<String> toppings = pizza.getTopping();
//            for(int i=0;i<toppings.size();i++){
//                String src = toppings.get(i);
//                String dst = new String(src.getBytes(Charset.forName("utf-8")));
//
//                toppings.set(i,dst);
//            }
//        }

        if(order.getPizzas()==null){
            order.setPizzas(new ArrayList<>());
        }
        order.getPizzas().add(pizza);
    }
}
