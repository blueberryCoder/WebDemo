package com.blueberry.pizza.beans;

import java.io.Serializable;
import java.util.List;


/**
 * Created by Administrator on 11/21/2016.
 */
public class Order implements Serializable {

    private static final long serialVersionUID = -2254399204993170446L;

    private Customer customer;
    private List<Pizza> pizzas;
    private Payment payment;

    public Order() {
    }

    public Order(Customer customer, List<Pizza> pizzas, Payment payment) {
        this.customer = customer;
        this.pizzas = pizzas;
        this.payment = payment;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
