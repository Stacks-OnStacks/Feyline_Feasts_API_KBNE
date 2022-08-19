package com.revature.project_1.Order_Details;


import com.revature.project_1.Order_Details.DTO.requests.EditODRequest;
import com.revature.project_1.Order_Details.DTO.requests.NewODRequest;
import com.revature.project_1.Order_Details.DTO.response.ODResponse;
import com.revature.project_1.util.exceptions.InvalidUserInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OrderDetailsService  {

    private final OrderDetailsDao odDao;
    private OrderDetails orderDetails= null;
    private final Logger logger= LogManager.getLogger();

    public OrderDetailsService(OrderDetailsDao odDao) {this.odDao = odDao;}



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


        details.setOrderDetailId(newOD.getOrderDetailId());
        details.setDishId(newOD.getDishId());
        details.setOrderId(newOD.getOrderId());
        details.setComments(newOD.getComments());
        details.setQuantity(newOD.getQuantity());


        logger.info("User registration service has begun with the provide: {}", details);
        if(!isPayValid(details)){
            throw new InvalidUserInputException("user input was invalid");
        }

        odDao.create(details);

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

        System.out.println(editODRequest.getId());
        Predicate<String> notNullorEmt= (str) -> str !=null && !str.trim().equals("");
        OrderDetails details =  odDao.findById(editODRequest.getId());


        if(notNullorEmt.test(editODRequest.getComments())){
            details.setComments(editODRequest.getComments());
        }
        if(editODRequest.getQuantity()!=0){
            details.setQuantity(editODRequest.getQuantity());
        }
        System.out.println(details.toString());
        return odDao.update(details);

    }

    public boolean remove(String id) {return odDao.delete(id);

    }
}
