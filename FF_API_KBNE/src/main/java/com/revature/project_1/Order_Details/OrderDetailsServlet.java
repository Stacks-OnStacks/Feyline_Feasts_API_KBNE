package com.revature.project_1.Order_Details;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project_1.Order_Details.DTO.requests.EditODRequest;
import com.revature.project_1.Order_Details.DTO.requests.NewODRequest;
import com.revature.project_1.Order_Details.DTO.response.ODResponse;
import com.revature.project_1.Users.User;
import com.revature.project_1.util.exceptions.InvalidUserInputException;
import com.revature.project_1.util.exceptions.ResourcePersistanceException;
import com.revature.project_1.util.interfaces.Authable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OrderDetailsServlet extends HttpServlet implements Authable {
    private final OrderDetailsService odService;
    private final ObjectMapper objectMapper;
    private final Logger logger= LogManager.getLogger();

    public OrderDetailsServlet(OrderDetailsService odService, ObjectMapper objectMapper) {
        this.odService = odService;
        this.objectMapper = objectMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String order_detail_id= req.getParameter("orderDetailId");

        if(order_detail_id!=null){
            try{
                ODResponse odResponse= odService.findById(order_detail_id);

                String payload = objectMapper.writeValueAsString(odResponse);
                resp.getWriter().write(payload);
            }
            catch (InvalidUserInputException e){
                logger.warn("Order Details information entered was not reflective of any user in the database. OrderDetails provided was: {}", order_detail_id);
                resp.getWriter().write("Order Details entered was not in the database.");
                resp.setStatus(404);
            }
        }
        else {
            System.out.println("all");
            List<ODResponse> odResponses = odService.readAll();
            String payload = objectMapper.writeValueAsString(odResponses);
            resp.getWriter().write(payload);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(!checkAuth(req, resp)) return;

        PrintWriter respWriter = resp.getWriter();
        NewODRequest newOD = objectMapper.readValue(req.getInputStream(), NewODRequest.class);
        User authUser= (User) req.getSession().getAttribute("authUser");


        try{
            logger.info("user request to add the following to the database: {}", newOD);
            ODResponse newODResp = odService.addOrderDetail(newOD);

            String payload= objectMapper.writeValueAsString(newODResp);

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
        EditODRequest editODRequest= objectMapper.readValue(req.getInputStream(), EditODRequest.class);

        try {
            odService.update(editODRequest);
            resp.getWriter().write("Order Details update successful");
        }catch (InvalidUserInputException e){
            resp.getWriter().write(e.getMessage());
            resp.setStatus(404);
        } catch (Exception e){
            resp.getWriter().write(e.getMessage() + " " + e.getClass().getName());
            resp.setStatus(500);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!checkAuth(req, resp)) return;
        EditODRequest editODRequest= objectMapper.readValue(req.getInputStream(), EditODRequest.class);
        String id = editODRequest.getId();
        System.out.println(id);
        if(id != null){
            odService.remove(id);
            resp.getWriter().write("Order Details with " + id + " has been deleted");
        } else {
            resp.getWriter().write("This request requires an id parameter in the path ?id=id");
            resp.setStatus(400);
        }
    }

}
