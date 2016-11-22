package com.blueberry.pizza.services;

import com.blueberry.pizza.beans.Order;
import com.blueberry.pizza.beans.Payment;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 11/21/2016.
 */
@Service
public class PizzaService {

    private Logger logger = Logger.getLogger(PizzaService.class);

    public boolean checkDeliveryArea(int zipCode) {
        return zipCode < 10;
    }

    public Payment verifyPayment(Payment payment){
        return payment;
    }

    public void saveOrder(Order order){
        logger.info(order);

    }
}
