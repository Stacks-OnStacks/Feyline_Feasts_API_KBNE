package com.revature.project_1.Order_Details;

public class OrderDetails {

    public long orderDetailId;
    public long dishId;
    public long orderId;
    public int quantity;
    public String comments;

    public OrderDetails(long orderDetailId, long dishId, long orderId, int quantity, String comments) {
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

    public long getDishId() {
        return dishId;
    }

    public void setDishId(long dishId) {
        this.dishId = dishId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
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
