package com.revature.project_1.Orders;

import com.revature.project_1.Orders.DTO.requests.NewOrderRequest;
import com.revature.project_1.Orders.DTO.response.OrderResponse;
import com.revature.project_1.Users.User;
import com.revature.project_1.Users_Payment.UserPayment;

import javax.persistence.*;
import java.util.Date;

@Entity(name="orders")
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int orderId;

    @Column(name = "amount")
    public int amount;
    @Column(name = "order_date")
    public Date orderDate;
    @Column(name = "order_address")
    public String orderAddress;
    @Column(name = "order_zip")
    public int orderZip;
    @ManyToOne
    @JoinColumn(name = "username")
    public User customerUsername;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    public UserPayment paymentId;

    public Order(){super();}



    public Order( int amount, Date orderDate, String orderAddress, int orderZip, User customerUsername, UserPayment paymentId) {

        this.amount = amount;
        this.orderDate = orderDate;
        this.orderAddress = orderAddress;
        this.orderZip = orderZip;
        this.customerUsername = customerUsername;
        this.paymentId = paymentId;
    }

    public Order(OrderResponse byOrderID) {
        this.orderId=byOrderID.getOrderId();
        this.amount = byOrderID.amount;
        this.orderDate = byOrderID.orderDate;
        this.orderAddress = byOrderID.orderAddress;
        this.orderZip = byOrderID.orderZip;
        this.customerUsername = byOrderID.customerUsername;
        this.paymentId = byOrderID.paymentId;

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
