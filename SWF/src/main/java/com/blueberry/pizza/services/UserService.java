package com.blueberry.pizza.services;

import com.blueberry.pizza.beans.Customer;
import com.blueberry.pizza.exceptions.CustomNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/21/2016.
 */
@Service
public class UserService {
    private List<Customer> customerList = new ArrayList<>();

    public Customer lookupCustomer(String phoneNumber) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getPhoneNumber().equals(phoneNumber)) {
                return customerList.get(i);
            }
        }
        throw new CustomNotFoundException();
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }
}
