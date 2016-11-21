package com.blueberry.pizza.services;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 11/21/2016.
 */
@Service
public class PizzaService {
    public boolean checkDeliveryArea(int zipCode) {
        return zipCode < 10;
    }
}
