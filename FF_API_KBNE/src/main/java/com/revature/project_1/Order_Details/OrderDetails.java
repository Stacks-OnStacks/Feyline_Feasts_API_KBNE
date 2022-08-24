package com.revature.project_1.Order_Details;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails {

    @Id
    public long orderDetailId;
    public String dishId;
    public String orderId;
    public int quantity;
    public String comments;

    public OrderDetails(long orderDetailId, String dishId, String orderId, int quantity, String comments) {
        this.orderDetailId = orderDetailId;
        this.dishId = dishId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.comments = comments;
    }

    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
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
}
