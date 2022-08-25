package com.revature.project_1.Order_Details;


import com.revature.project_1.Dish.Dish;
import com.revature.project_1.Dish.DishService;
import com.revature.project_1.Order_Details.DTO.requests.EditODRequest;
import com.revature.project_1.Order_Details.DTO.requests.NewODRequest;
import com.revature.project_1.Order_Details.DTO.response.ODResponse;
import com.revature.project_1.Orders.Order;
import com.revature.project_1.Orders.OrderService;
import com.revature.project_1.Users_Payment.UserPaymentDao;
import com.revature.project_1.util.exceptions.InvalidUserInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OrderDetailsService  {

    private final OrderDetailsDao odDao;
    private final UserPaymentDao upDao;
    private final DishService dishService;
    private OrderService orderService;

    private final Logger logger= LogManager.getLogger();

    public OrderDetailsService(OrderDetailsDao odDao, UserPaymentDao paymentDao, DishService dishService) {this.odDao = odDao;
        this.upDao=paymentDao;
        this.dishService=dishService;
    }



    public ODResponse findById(String order_detail_id) {
        OrderDetails oDetails = odDao.findById(order_detail_id);
        ODResponse odResponse = new ODResponse(oDetails);
        return odResponse;
    }

    public List<ODResponse> readAll() {
        List<ODResponse> odResponses = odDao.findAll()
                .stream()
                .map(ODResponse::new)
                .collect(Collectors.toList());
        return odResponses;

    }

    public ODResponse addOrderDetail(NewODRequest newOD) {

        OrderDetails details= new OrderDetails();

        Dish wantDish=new Dish(dishService.findByDishID(""+newOD.getDishId()));
        Order wantOrder=new Order(orderService.findByOrderID(""+newOD.getOrderId()));

        details.setDishId(wantDish);
        details.setOrderId(wantOrder);
        details.setComments(newOD.getComments());
        details.setQuantity(newOD.getQuantity());


        logger.info("User registration service has begun with the provide: {}", details);


        odDao.create(details);
        details.getOrderId().getPaymentId().setBalance(details.getOrderId().getPaymentId().getBalance()-details.getOrderId().getAmount()*details.getDishId().getCost());
        upDao.update(details.getOrderId().getPaymentId());

        return new ODResponse(details);

    }

    private boolean isPayValid(OrderDetails details) {
        if(details==null)return false;

        if(details.getOrderDetailId()==0)return false;
        if(details.getQuantity()==0)return false;
        if(details.getOrderId()==null)return false;
        if(details.getDishId()==null)return false;
        if(details.getComments()==null&&details.getComments().trim().equals(""))return false;

        return true;
    }

    public boolean update(EditODRequest editODRequest) {
        System.out.println("*******************");
        System.out.println("+"+editODRequest.getOrderDetailId()+"+");
        System.out.println("*******************");
        Predicate<String> notNullorEmt= (str) -> str !=null && !str.trim().equals("");
        OrderDetails details =  odDao.findById(editODRequest.getOrderDetailId().trim());
        double old=0;


        if(notNullorEmt.test(editODRequest.getComments())){
            details.setComments(editODRequest.getComments());
        }
        if(editODRequest.getQuantity()!=0){
            old=details.getQuantity();
            details.setQuantity(editODRequest.getQuantity());
        }
        System.out.println(details.toString());
        if(old!=0){
            details.getOrderId().getPaymentId().setBalance(details.getOrderId().getPaymentId().getBalance()-
                    (details.getOrderId().getAmount()*details.getDishId().getCost()*(old-details.getQuantity())));
            upDao.update(details.getOrderId().getPaymentId());

        }

        return odDao.update(details);

    }

    public boolean remove(String id) {
        return odDao.delete(id);
    }

    public List<ODResponse> findByOrder(String order) {
        return odDao.findByOrder(order);
    }

    public void addOrderService(OrderService orderService) {
        this.orderService=orderService;
    }
}
