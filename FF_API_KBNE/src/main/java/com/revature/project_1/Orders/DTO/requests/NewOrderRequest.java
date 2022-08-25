package com.revature.project_1.Orders.DTO.requests;

import com.revature.project_1.Users.User;
import com.revature.project_1.Users_Payment.UserPayment;

import java.util.Date;

public class NewOrderRequest {

    public int amount;
    public Date orderDate;
    public String orderAddress;
    public int orderZip;
    public User customerUsername;
    public String paymentId;


    public  NewOrderRequest(){}
    public NewOrderRequest(int amount, Date orderDate, String orderAddress, int orderZip, User customerUsername, String paymentId) {
        this.amount = amount;
        this.orderDate = orderDate;
        this.orderAddress = orderAddress;
        this.orderZip = orderZip;
        this.customerUsername = customerUsername;
        this.paymentId = paymentId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public int getOrderZip() {
        return orderZip;
    }

    public void setOrderZip(int orderZip) {
        this.orderZip = orderZip;
    }

    public User getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(User customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
}
