package com.revature.project_1.Orders;

import java.util.Date;

public class Order {

    public String orderId;
    public int amount;
    public Date orderDate;
    public String orderAddress;
    public int orderZip;
    public String customerUsername;
    public long paymentId;


    public Order( int amount, Date orderDate, String orderAddress, int orderZip, String customerUsername, long paymentId) {

        this.amount = amount;
        this.orderDate = orderDate;
        this.orderAddress = orderAddress;
        this.orderZip = orderZip;
        this.customerUsername = customerUsername;
        this.paymentId = paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }
}
