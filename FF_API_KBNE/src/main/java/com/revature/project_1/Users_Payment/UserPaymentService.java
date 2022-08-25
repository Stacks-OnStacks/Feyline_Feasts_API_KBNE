package com.revature.project_1.Users_Payment;

import com.revature.project_1.Order_Details.DTO.response.ODResponse;
import com.revature.project_1.Orders.DTO.response.OrderResponse;
import com.revature.project_1.Orders.OrderService;
import com.revature.project_1.Users_Payment.DTO.requests.EditUPRequest;
import com.revature.project_1.Users_Payment.DTO.requests.NewUPRequest;
import com.revature.project_1.Users_Payment.DTO.response.UPResponse;
import com.revature.project_1.util.exceptions.InvalidUserInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserPaymentService  {

    private final UserPaymentDao upDao;
    private final OrderService orderService;
    private UserPayment sessionUP= null;
    private final Logger logger= LogManager.getLogger();

    public UserPaymentService(UserPaymentDao upDao, OrderService orderService) {
        this.upDao = upDao;
        this.orderService = orderService;
    }

    public UPResponse findByUPId(String paymentid) {
        UserPayment userPay=upDao.findById(paymentid);
        UPResponse upResponse= new UPResponse(userPay);
        return upResponse;
    }

    public List<UPResponse> readAll() {
        List<UPResponse> userpays = upDao.findAll()
                .stream()
                .map(UPResponse::new)
                .collect(Collectors.toList());
        return userpays;
    }

    public UPResponse registerUserPayment(NewUPRequest userPay) {
        UserPayment userPayment= new UserPayment();


        userPayment.setBalance(userPay.getBalance());
        userPayment.setExpDate(userPay.getExpDate());
        userPayment.setCcv(userPay.getCcv());
        userPayment.setZipCode(userPay.getZipCode());
        userPayment.setCustomerUsername(userPay.getCustomerUsername());

        logger.info("User registration service has begun with the provide: {}", userPayment);
        if(!isPayValid(userPayment)){
            throw new InvalidUserInputException("user input was invalid");
        }

        upDao.create(userPayment);

        return new UPResponse(userPayment);

    }

    private boolean isPayValid(UserPayment userPayment) {
        if(userPayment==null) {return false;}


        if(userPayment.getExpDate()==null &&userPayment.getExpDate().trim().equals("")) {return false;}
        if(userPayment.getCustomerUsername()==null ) {return false;}
        if(userPayment.getCcv()==0 ) {return false;}
        if(userPayment.getBalance()==0 ) {return false;}
        if(userPayment.getZipCode()==0 ) {return false;}

        return true;
    }

    public boolean update(EditUPRequest userPay, String username) throws NumberFormatException{
        System.out.println(userPay.getId());
        Predicate<String> notNullorEmt= (str) -> str !=null && !str.trim().equals("");
        UserPayment foundpay =  upDao.findById(userPay.getId());

        System.out.println("*1*"+foundpay.getCustomerUsername().getUsername());
        System.out.println("*2*"+username);

        if(!foundpay.getCustomerUsername().getUsername().equals(username))return false;


        if(notNullorEmt.test(userPay.getExpDate())){
            foundpay.setExpDate(userPay.getExpDate());
        }
        if(userPay.getCcv()!=0){
            foundpay.setCcv(userPay.getCcv());
        }
        if(userPay.getBalance()!=0){
            foundpay.setBalance(userPay.getBalance());
        }
        if(userPay.getZipCode()!=0){
            foundpay.setZipCode(userPay.getZipCode());
        }
        System.out.println(foundpay.toString());
        return upDao.update(foundpay);

    }

    public boolean update(EditUPRequest userPay, boolean admin) throws NumberFormatException{
        System.out.println(userPay.getId());
        Predicate<String> notNullorEmt= (str) -> str !=null && !str.trim().equals("");
        UserPayment foundpay =  upDao.findById(userPay.getId());


        if(!admin)return false;


        if(notNullorEmt.test(userPay.getExpDate())){
            foundpay.setExpDate(userPay.getExpDate());
        }
        if(userPay.getCcv()!=0){
            foundpay.setCcv(userPay.getCcv());
        }
        if(userPay.getBalance()!=0){
            foundpay.setBalance(userPay.getBalance());
        }
        if(userPay.getZipCode()!=0){
            foundpay.setZipCode(userPay.getZipCode());
        }
        System.out.println(foundpay.toString());
        return upDao.update(foundpay);

    }

    public boolean remove(String userPay,String username) {

        UserPayment foundpay =  upDao.findById(userPay);
        if(!foundpay.getCustomerUsername().getUsername().equals(username))return false;

        List<OrderResponse> ods =orderService.findByUserPay(userPay);
        if(!ods.isEmpty()) {
            OrderResponse cur;
            for (int i=0;i<ods.size();i++){
                cur = ods.get(i);
                orderService.remove(""+cur.getPaymentId().paymentId);
            }
        }

        return upDao.delete(userPay);
    }

    public boolean remove(String userPay,boolean username) {

        UserPayment foundpay =  upDao.findById(userPay);
        if(username)return false;

        return upDao.delete(userPay);
    }

    public List<UserPayment> findByUsername(String username) {
        return upDao.findByUsername(username);
    }
}
