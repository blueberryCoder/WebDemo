package com.blueberry.ssh.actions;

import com.blueberry.ssh.bo.CustomerBo;
import com.blueberry.ssh.model.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    Customer customer = new Customer();

    List<Customer> customerList = new ArrayList<Customer>();

    private CustomerBo customerBo;


    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public void setCustomerBo(CustomerBo customerBo) {
        this.customerBo = customerBo;
    }

    public Customer getModel() {
        return customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    // save customer
    public String addCustomer() throws Exception {
//        SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext()
//                .getAttribute(HibernateListener.KEY_NAME);
//        Session session = sessionFactory.openSession();
//        //save it
//        customer.setCreateDate(new Date());
//        session.beginTransaction();
//        session.save(customer);
//        session.getTransaction().commit();
//        //reload the customer list
//        customerList = session.createQuery(" from Customer ").list();
        customer.setCreateDate(new Date());
        customerBo.addCustomer(customer);
        customerList = customerBo.listCustomer();

        return SUCCESS;
    }

    // list all customers
    public String listCustomer() throws Exception{
//        SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext()
//                .getAttribute(HibernateListener.KEY_NAME);
//        Session session = sessionFactory.openSession();
//        customerList = session.createQuery("from Customer ").list();
        customerList = customerBo.listCustomer();
        return SUCCESS;
    }

}
