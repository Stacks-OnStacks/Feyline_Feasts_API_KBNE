package com.revature.project_1.Orders.DTO.response;

import com.revature.project_1.Orders.Order;
import com.revature.project_1.Users.User;
import com.revature.project_1.Users_Payment.UserPayment;

import java.util.Date;

public class OrderResponse {


    public String orderId;
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

    public OrderResponse(String orderId, int amount, Date orderDate, String orderAddress, int orderZip, User customerUsername, UserPayment paymentId) {
        this.orderId = orderId;
        this.amount = amount;
        this.orderDate = orderDate;
        this.orderAddress = orderAddress;
        this.orderZip = orderZip;
        this.customerUsername = customerUsername;
        this.paymentId = paymentId;
    }
}
