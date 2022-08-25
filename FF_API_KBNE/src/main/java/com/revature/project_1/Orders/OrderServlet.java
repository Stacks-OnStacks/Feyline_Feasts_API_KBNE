package com.revature.project_1.Orders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project_1.Dish.DTO.requests.EditDishRequest;
import com.revature.project_1.Dish.DTO.response.DishResponse;
import com.revature.project_1.Orders.DTO.requests.EditOrderRequest;
import com.revature.project_1.Orders.DTO.requests.NewOrderRequest;
import com.revature.project_1.Orders.DTO.response.OrderResponse;
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

public class OrderServlet extends HttpServlet  implements Authable {

    private final OrderService orderService;
    private final ObjectMapper objectMapper;
    private final Logger logger= LogManager.getLogger();

    public OrderServlet(OrderService orderService, ObjectMapper objectMapper) {
        this.orderService = orderService;
        this.objectMapper = objectMapper;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!checkAuth(req, resp))return;

        String id = req.getParameter("orderId");

        if(id!=null) {
            try {
                OrderResponse order = orderService.findByOrderID(id);

                String payload = objectMapper.writeValueAsString(order);
                resp.getWriter().write(payload);

            } catch (InvalidUserInputException e) {
                logger.warn("order information entered was not reflective of any dish in the database. id provided was: {}", id);
                resp.getWriter().write("order entered was not in the database.");
                resp.setStatus(404);
            }
        }
        else {
            if(checkAdmin(req, resp)) {
                List<OrderResponse> order = orderService.readAll();

                String payload = objectMapper.writeValueAsString(order);

                resp.getWriter().write(payload);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(!checkAuth(req,resp))return;

        PrintWriter respWriter =resp.getWriter();

        NewOrderRequest order= objectMapper.readValue(req.getInputStream(), NewOrderRequest.class);
        order.setCustomerUsername((User) req.getSession().getAttribute("authUser"));

        try{
            logger.info("Order request to add the following to the database: {}", order);
            OrderResponse newOrder = orderService.registerOrder(order);

            String payload= objectMapper.writeValueAsString(newOrder);

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
        EditOrderRequest editOrder = objectMapper.readValue(req.getInputStream(), EditOrderRequest.class);

        try {
            orderService.update(editOrder);
            resp.getWriter().write("Order update successful");
        } catch (InvalidUserInputException e) {
            resp.getWriter().write(e.getMessage());
            resp.setStatus(404);
        } catch (Exception e) {
            resp.getWriter().write(e.getMessage() + " " + e.getClass().getName());
            resp.setStatus(500);
        }
    }

    @Override
    protected void doDelete (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if (!checkAuth(req, resp)) return;
        String orderId = req.getParameter("OrderId");
        if (orderId != null) {
            orderService.remove(orderId);
            resp.getWriter().write("User with " + orderId + " has been deleted");
        } else {
            resp.getWriter().write("This request requires an email parameter in the path ?email=example@mail.com");
            resp.setStatus(400);
        }
    }

}
