package com.revature.project_1.Order_Details;

import com.revature.project_1.Dish.Dish;
import com.revature.project_1.Order_Details.DTO.requests.EditODRequest;
import com.revature.project_1.Order_Details.DTO.response.ODResponse;
import com.revature.project_1.Orders.Order;

import javax.persistence.*;

@Entity(name="orderdetails")
@Table(name="orderdetails")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    public int orderDetailId;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    public Dish dishId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    public Order orderId;

    @Column(name = "quantity")
    public int quantity;

    @Column(name = "comments")
    public String comments;

    public  OrderDetails(){}
    public OrderDetails(int orderDetailId, Dish dishId, Order orderId, int quantity, String comments) {
        this.orderDetailId = orderDetailId;
        this.dishId = dishId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.comments = comments;
    }

    public OrderDetails(EditODRequest editODRequests){
        this.orderDetailId = Integer.parseInt(editODRequests.orderDetailId);
        this.dishId =  editODRequests.dishId;
        this.orderId = editODRequests.orderId;
        this.quantity = editODRequests.quantity;
        this.comments = editODRequests.comments;
    }

    public OrderDetails(ODResponse byId) {
        this.orderDetailId = byId.orderDetailId;
        this.dishId =  byId.dishId;
        this.orderId = byId.orderId;
        this.quantity = byId.quantity;
        this.comments = byId.comments;
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
        return "OrderDetails{" +
                "orderDetailId=" + orderDetailId +
                ", dishId='" + dishId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", quantity=" + quantity +
                ", comments='" + comments + '\'' +
                '}';
    }
}
