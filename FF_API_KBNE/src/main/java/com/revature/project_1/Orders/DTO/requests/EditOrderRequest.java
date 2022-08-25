package com.revature.project_1.Orders.DTO.requests;

import com.revature.project_1.util.web.DTO.EditResourceRequest;

import java.util.Date;

public class EditOrderRequest extends EditResourceRequest {



    public String orderId=super.getId();
    public int amount;
    public Date orderDate;
    public String orderAddress;
    public int orderZip;

    public EditOrderRequest(int amount, Date orderDate, String orderAddress, int orderZip) {
        this.amount = amount;
        this.orderDate = orderDate;
        this.orderAddress = orderAddress;
        this.orderZip = orderZip;
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

    @Override
    public String toString() {
        return "EditOrderRequest{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", orderDate=" + orderDate +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderZip=" + orderZip +
                '}';
    }
}
