package com.revature.project_1.Order_Details.DTO.requests;

import com.revature.project_1.Dish.Dish;
import com.revature.project_1.Orders.Order;

public class NewODRequest {

    public int orderDetailId;
    public Dish dishId;
    public Order orderId;
    public int quantity;
    public String comments;

    public NewODRequest() {
    }

    public NewODRequest(int orderDetailId, Dish dishId, Order orderId, int quantity, String comments) {
        this.orderDetailId = orderDetailId;
        this.dishId = dishId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.comments = comments;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Dish getDishId() {
        return dishId;
    }

    public void setDishId(Dish dishId) {
        this.dishId = dishId;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "NewODRequest{" +
                "orderDetailId='" + orderDetailId + '\'' +
                ", dishId='" + dishId + '\'' +
                ", orderId=" + orderId +
                ", quantity=" + quantity +
                ", comments='" + comments + '\'' +
                '}';
    }
}
