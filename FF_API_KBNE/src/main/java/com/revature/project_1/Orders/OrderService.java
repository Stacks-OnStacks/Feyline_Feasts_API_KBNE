package com.revature.project_1.Orders;

import com.revature.project_1.Order_Details.DTO.response.ODResponse;
import com.revature.project_1.Order_Details.OrderDetailsService;
import com.revature.project_1.Orders.DTO.requests.EditOrderRequest;
import com.revature.project_1.Orders.DTO.requests.NewOrderRequest;
import com.revature.project_1.Orders.DTO.response.OrderResponse;
import com.revature.project_1.Users_Payment.UserPaymentDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OrderService {

    private final OrderDao orderDao;
    private final OrderDetailsService orderDetailsService;
    private final UserPaymentDao upDao;

    private final Logger logger = LogManager.getLogger();

    public OrderService(OrderDao orderDao, OrderDetailsService orderDetailsService, UserPaymentDao upDao) {

        this.orderDao = orderDao;
        this.orderDetailsService = orderDetailsService;
        this.upDao = upDao;
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
        requestOrder.setPaymentId(upDao.findById(newOrder.getPaymentId()));

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
        List<ODResponse> ods =orderDetailsService.findByOrder(order);
        if(!ods.isEmpty()) {
            ODResponse cur;
            for (int i=0;i<ods.size();i++){
                cur = ods.get(i);
                orderDetailsService.remove(""+cur.orderDetailId);
            }
        }
        return orderDao.delete(order);
    }

    public List<OrderResponse> findByUserPay(String userPay) {
        return orderDao.findByUserPay(userPay);
    }
}

