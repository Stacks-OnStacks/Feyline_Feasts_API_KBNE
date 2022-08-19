package com.revature.project_1.Order_Details.DTO.response;

import com.revature.project_1.Dish.Dish;
import com.revature.project_1.Order_Details.OrderDetails;
import com.revature.project_1.Orders.Order;

public class ODResponse {

    public int orderDetailId;
    public Dish dishId;
    public Order orderId;
    public int quantity;
    public String comments;
    public ODResponse(OrderDetails oDetails) {
        this.orderDetailId=oDetails.getOrderDetailId();
        this.dishId=oDetails.getDishId();
        this.orderId=oDetails.getOrderId();
        this.quantity=oDetails.getQuantity();
        this.comments=oDetails.getComments();


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
        return "ODResponse{" +
                "orderDetailId=" + orderDetailId +
                ", dishId=" + dishId +
                ", orderId=" + orderId +
                ", quantity=" + quantity +
                ", comments='" + comments + '\'' +
                '}';
    }
}
