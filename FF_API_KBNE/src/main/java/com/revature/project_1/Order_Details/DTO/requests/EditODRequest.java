package com.revature.project_1.Order_Details.DTO.requests;

import com.revature.project_1.Dish.Dish;
import com.revature.project_1.Orders.Order;
import com.revature.project_1.util.web.DTO.EditResourceRequest;

public class EditODRequest extends EditResourceRequest {


    public String orderDetailId =super.id;
    public Dish dishId;
    public Order orderId;
    public int quantity;
    public String comments;



    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
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
        return "EditODRequests{" +
                "orderDetailId='" + orderDetailId + '\'' +
                ", dishId='" + dishId + '\'' +
                ", orderId=" + orderId +
                ", quantity=" + quantity +
                ", comments='" + comments + '\'' +
                '}';
    }
}
