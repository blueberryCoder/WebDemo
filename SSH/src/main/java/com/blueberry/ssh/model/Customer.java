package com.blueberry.ssh.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/10/27.
 */
public class Customer implements Serializable {

    private long customerId;
    private String name;
    private String address;
    private Date createDate;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
