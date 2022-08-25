package com.revature.project_1.Orders.DTO.response;

import com.revature.project_1.Orders.Order;
import com.revature.project_1.Users.User;
import com.revature.project_1.Users_Payment.UserPayment;

import java.util.Date;

public class OrderResponse {


    public int orderId;
    public int amount;
    public Date orderDate;
    public String orderAddress;
    public int orderZip;
    public User customerUsername;
    public UserPayment paymentId;


    public  OrderResponse(Order order){

        this.orderId = order.getOrderId();
        this.amount = order.getAmount();
        this.orderDate = order.getOrderDate();
        this.orderAddress = order.getOrderAddress();
        this.orderZip = order.getOrderZip();
        this.customerUsername = order.getCustomerUsername();
        this.paymentId = order.getPaymentId();

    }

    public OrderResponse(int orderId, int amount, Date orderDate, String orderAddress, int orderZip, User customerUsername, UserPayment paymentId) {
        this.orderId = orderId;
        this.amount = amount;
        this.orderDate = orderDate;
        this.orderAddress = orderAddress;
        this.orderZip = orderZip;
        this.customerUsername = customerUsername;
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
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

    public User getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(User customerUsername) {
        this.customerUsername = customerUsername;
    }

    public UserPayment getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UserPayment paymentId) {
        this.paymentId = paymentId;
    }
}
