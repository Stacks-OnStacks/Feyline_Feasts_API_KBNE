package com.revature.project_1.Users_Payment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project_1.Users.User;
import com.revature.project_1.Users_Payment.DTO.requests.EditUPRequests;
import com.revature.project_1.Users_Payment.DTO.requests.NewUPRequest;
import com.revature.project_1.Users_Payment.DTO.response.UPResponse;
import com.revature.project_1.util.exceptions.InvalidUserInputException;
import com.revature.project_1.util.exceptions.ResourcePersistanceException;
import com.revature.project_1.util.interfaces.Authable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class UserPaymentServlet extends HttpServlet implements Authable {

    private final UserPaymentService uPService;
    private final ObjectMapper objectMapper;
    private final Logger logger= LogManager.getLogger();

    public UserPaymentServlet(UserPaymentService uPService, ObjectMapper objectMapper) {
        this.uPService = uPService;
        this.objectMapper = objectMapper;
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paymentid= req.getParameter("paymentid");

        if(paymentid!=null){
            try{
                UPResponse upResponse= uPService.findByUPId(paymentid);

                String payload = objectMapper.writeValueAsString(upResponse);
                resp.getWriter().write(payload);
            }
            catch (InvalidUserInputException e){
                logger.warn("User information entered was not reflective of any user in the database. Payment Id provided was: {}", paymentid);
                resp.getWriter().write("Payment Id entered was not in the database.");
                resp.setStatus(404);
            }
        }
        else {
            List<UPResponse> users = uPService.readAll();
            String payload = objectMapper.writeValueAsString(users);
            resp.getWriter().write(payload);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!checkAuth(req, resp)) return;

        PrintWriter respWriter = resp.getWriter();

        NewUPRequest userPay = objectMapper.readValue(req.getInputStream(), NewUPRequest.class);
        User authUser= (User) req.getSession().getAttribute("authUser");
        userPay.setCustomerUsername(authUser);
        System.out.println(userPay);
        try{
            logger.info("Payment request to add the following to the database: {}", userPay);
            UPResponse newUserPay = uPService.registerUserPayment(userPay);

            String payload= objectMapper.writeValueAsString(newUserPay);

            respWriter.write(payload);
            resp.setStatus(201);
        } catch (InvalidUserInputException | ResourcePersistanceException e){
            logger.warn("Exception thrown when trying to persist. Message from exception: {}", e.getMessage());
            respWriter.write(e.getMessage());
            resp.setStatus(404);
        } catch (Exception e){
            logger.error("Something unexpected happened and this exception was thrown: {} with message: {}", e.getClass().getName(), e.getMessage());
            respWriter.write(e.getMessage() + " " + e.getClass().getName());
            resp.setStatus(500);
        }

    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(!checkAuth(req, resp)) return;
        EditUPRequests userPay = objectMapper.readValue(req.getInputStream(), EditUPRequests.class);

        try {
            uPService.update(userPay);
            resp.getWriter().write("User update successful");
        }catch (InvalidUserInputException e){
            resp.getWriter().write(e.getMessage());
            resp.setStatus(404);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            resp.getWriter().write("ID must be a numeric value.");


        }catch (Exception e){
            resp.getWriter().write(e.getMessage() + " " + e.getClass().getName());
            resp.setStatus(500);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!checkAuth(req, resp)) return;
        EditUPRequests editUser= objectMapper.readValue(req.getInputStream(),EditUPRequests.class);

        String userPay = editUser.getId();
        System.out.println(editUser.getId());
        if(userPay != null){
            uPService.remove(userPay);
            resp.getWriter().write("User with " + userPay + " has been deleted");
        } else {
            resp.getWriter().write("This request requires an Id parameter in the path ?ID=number");
            resp.setStatus(400);
        }
    }
}
