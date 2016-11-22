package com.blueberry.pizza.beans;

import java.io.Serializable;

/**
 * Created by Administrator on 11/21/2016.
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = 8363221482427098796L;
    private String username;
    private String phoneNumber;
    private String address;
    private int zipCode; // 根据此 判断是否需要配送

    public Customer() {
    }

    public Customer(String username, String phoneNumber, String address) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Customer(String username, String phoneNumber, String address, int zipCode) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipCode = zipCode;
    }

    public String getUsername() {
        return username;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
