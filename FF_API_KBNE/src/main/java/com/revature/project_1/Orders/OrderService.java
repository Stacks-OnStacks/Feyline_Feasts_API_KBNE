package com.revature.project_1.Orders;

import com.revature.project_1.Dish.DTO.requests.EditDishRequest;
import com.revature.project_1.Dish.DTO.requests.NewDishIDRequest;
import com.revature.project_1.Dish.DTO.response.DishResponse;
import com.revature.project_1.Dish.Dish;
import com.revature.project_1.Dish.DishDao;
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

        Order order = orderDao.findByOrderId(OrderId);
        OrderResponse orderResponse = new OrderResponse(order);
        return dishResponse;
    }

    public List<OrderResponse> readAll() {
        List<OrderResponse> orders = orderDao.findAll()
                .stream()
                .map(OrderResponse::new)
                .collect(Collectors.toList());

        return orders;
    }

    public OrderResponse registerOrder(NewOrderIDRequest newOrder) {
        Order requestOrder = new Order();

        requestOrder.setOrderName(newOrder.getOrderName());
        requestOrder.setOrderAddress(newOrder.getOrderAddress());
        requestOrder.setOrderZip(newOrder.getOrderZip());
        requestOrder.SetCustomerUsername(newOrder.getCustomerUsername());
        requestOrder.setPaymentId(newOrder.getPaymentId());

//        if (!isDishAvailable("" + requestDish.getDishId())) {
//            throw new InvalidUserInputException("Dish not available.");
//        }
        dishDao.create(requestDish);
        return new DishResponse(requestDish);

    }

    public boolean update(EditOrderRequest editOrder) {
        Order foundOrder= orderDao.findByOrderId(editOrder.getOrderId());

        Predicate<String> notNullorEmt= (str) -> str !=null&& str.trim().equals("");

        if (notNullorEmt.test(editOrder.getOrderName())){
            foundOrder.setOrderName(editOrder.getOrderName());
        }
        if (0!=(editOrder.getCost())){
            foundOrder.setCost(editOrder.getCost());
        }
        if (notNullorEmt.test(editOrder.getDescription())){
            foundOrder.setDescription(editOrder.getDescription());
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