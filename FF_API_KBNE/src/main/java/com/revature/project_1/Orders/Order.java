package com.revature.project_1.Orders;

import javax.persistence.*;
import java.util.Date;

@Entity(name="order")
@Table(name="order")
public class Order {

<<<<<<< HEAD
    public String orderId;
=======
    @Id
    @GeneratedValue
    public String orderId;

    @Column(name = "amount")
>>>>>>> origin/ksidenew
    public int amount;
    @Column(name = "order_date")
    public Date orderDate;
    @Column(name = "order_address")
    public String orderAddress;
    @Column(name = "order_zip")
    public int orderZip;
    @Column(name = "customer_username")
    public String customerUsername;
    public long paymentId;

    public Oder(){super();}

    public Order( int amount, Date orderDate, String orderAddress, int orderZip, String customerUsername, long paymentId) {

<<<<<<< HEAD
    public Order( int amount, Date orderDate, String orderAddress, int orderZip, String customerUsername, long paymentId) {

=======
>>>>>>> origin/ksidenew
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

    @Override
    public String toString() {
        return "Order{" +
                "amount=" + amount +
                ", orderDate='" + orderDate +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderZip=" + orderZip +
                ", customerUsername='" + customerUsername + '\'' +
                ", paymentId=" + paymentId +
                '}';
    }
}

// this.amount = amount;
//         this.orderDate = orderDate;
//         this.orderAddress = orderAddress;
//         this.orderZip = orderZip;
//         this.customerUsername = customerUsername;
//         this.paymentId = paymentId;