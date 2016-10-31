package com.blueberry.ssh.dao.impl;

import com.blueberry.ssh.dao.CustomerDao;

import com.blueberry.ssh.model.Customer;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/10/28.
 */
@Transactional
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    public void addCustomer(Customer customer) {
        getHibernateTemplate().save(customer);
    }

    public List<Customer> lisCustomer() {
        return (List<Customer>) getHibernateTemplate().find("from Customer ");
    }
}