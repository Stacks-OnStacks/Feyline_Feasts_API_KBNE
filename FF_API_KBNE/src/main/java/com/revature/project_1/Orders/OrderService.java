package com.revature.project_1.Orders;

import com.revature.project_1.Dish.DTO.requests.EditDishRequest;
import com.revature.project_1.Dish.DTO.requests.NewDishIDRequest;
import com.revature.project_1.Dish.DTO.response.DishResponse;
import com.revature.project_1.Dish.Dish;
import com.revature.project_1.Dish.DishDao;
import com.revature.project_1.Orders.DTO.requests.EditOrderRequest;
import com.revature.project_1.Orders.DTO.requests.NewOrderRequest;
import com.revature.project_1.Orders.DTO.response.OrderResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OrderService {

    private final OrderDao orderDao;

    private Order sessionUser = null;

    private final Logger logger = LogManager.getLogger();

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public OrderResponse findByOrderID(String OrderId) {

        Order order = orderDao.findById(OrderId);
        OrderResponse orderResponse = new OrderResponse(order);
        return orderResponse;
    }

    public List<OrderResponse> readAll() {
        List<OrderResponse> orders = orderDao.findAll()
                .stream()
                .map(OrderResponse::new)
                .collect(Collectors.toList());

        return orders;
    }

    public OrderResponse registerOrder(NewOrderRequest newOrder) {
        Order requestOrder = new Order();

        requestOrder.setAmount(newOrder.getAmount());
        requestOrder.setOrderDate(newOrder.getOrderDate());
        requestOrder.setOrderAddress(newOrder.getOrderAddress());
        requestOrder.setOrderZip(newOrder.getOrderZip());
        requestOrder.setCustomerUsername(newOrder.getCustomerUsername());
        requestOrder.setPaymentId(newOrder.getPaymentId());

        orderDao.create(requestOrder);
        return new OrderResponse(requestOrder);

    }

    public boolean update(EditOrderRequest editOrder) {
        Order foundOrder= orderDao.findById(editOrder.getOrderId());

        Predicate<String> notNullorEmt= (str) -> str !=null&& str.trim().equals("");

        if ((editOrder.getAmount()!=0)){
            foundOrder.setAmount(editOrder.getAmount());
        }
        if ((editOrder.getOrderDate()==null)){
            foundOrder.setAmount(editOrder.getAmount());
        }
        if (notNullorEmt.test(editOrder.getOrderAddress())){
            foundOrder.setOrderAddress(editOrder.getOrderAddress());
        }
        if ((editOrder.getOrderZip()!=0)){
            foundOrder.setAmount(editOrder.getAmount());
        }

        return orderDao.update(foundOrder);

    }

    public boolean remove(String order) {
        return orderDao.delete(order);
    }
}

// this.amount = amount;
//         this.orderDate = orderDate;
//         this.orderAddress = orderAddress;
//         this.orderZip = orderZip;
//         this.customerUsername = customerUsername;
//         this.paymentId = paymentId;