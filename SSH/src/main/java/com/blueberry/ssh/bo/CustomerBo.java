package com.blueberry.ssh.bo;

import com.blueberry.ssh.model.Customer;

import java.util.List;

/**
 * Created by Administrator on 2016/10/28.
 */
public interface CustomerBo {
    void addCustomer(Customer customer);
    List<Customer> listCustomer();
}
