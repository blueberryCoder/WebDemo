package com.blueberry.ssh.bo.impl;

import com.blueberry.ssh.bo.CustomerBo;
import com.blueberry.ssh.dao.CustomerDao;
import com.blueberry.ssh.model.Customer;

import java.util.List;

/**
 * Created by Administrator on 2016/10/28.
 */
public class CustomerBoImpl implements CustomerBo {

    CustomerDao customerDao;

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public List<Customer> listCustomer() {
        return customerDao.lisCustomer();
    }
}
