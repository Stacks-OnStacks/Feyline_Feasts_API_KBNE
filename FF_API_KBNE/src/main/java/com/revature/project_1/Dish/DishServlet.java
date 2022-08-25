package com.revature.project_1.Dish;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project_1.Dish.DTO.requests.EditDishRequest;
import com.revature.project_1.Dish.DTO.requests.NewDishIDRequest;
import com.revature.project_1.Dish.DTO.response.DishResponse;
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

public class DishServlet extends HttpServlet  implements Authable {

    private final DishService dishService;
    private final ObjectMapper objectMapper;
    private final Logger logger= LogManager.getLogger();

    public DishServlet(DishService dishService, ObjectMapper objectMapper) {
        this.dishService = dishService;
        this.objectMapper = objectMapper;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("dishId");

        if(id!=null) {
            try {
                DishResponse dish = dishService.findByDishID(id);

                String payload = objectMapper.writeValueAsString(dish);
                resp.getWriter().write(payload);

            } catch (InvalidUserInputException e) {
                logger.warn("dish information entered was not reflective of any dish in the database. id provided was: {}", id);
                resp.getWriter().write("dish entered was not in the database.");
                resp.setStatus(404);
            }
        }
        else {
            List<DishResponse> dish = dishService.readAll();

            String payload = objectMapper.writeValueAsString(dish);

            resp.getWriter().write(payload);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!checkAuth(req,resp))return;
        if(!checkAdmin(req,resp))return;

        PrintWriter respWriter =resp.getWriter();
        NewDishIDRequest dish= objectMapper.readValue(req.getInputStream(), NewDishIDRequest.class);


        try{
            logger.info("user request to add the following to the database: {}", dish);
            DishResponse newDish = dishService.registerDish(dish);

            String payload= objectMapper.writeValueAsString(newDish);

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
        if(!checkAuth(req,resp))return;
        if(!checkAdmin(req,resp))return;

        EditDishRequest editDish = objectMapper.readValue(req.getInputStream(), EditDishRequest.class);

        try {
            dishService.update(editDish);
            resp.getWriter().write("User update successful");
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
        if(!checkAuth(req,resp))return;
        if(!checkAdmin(req,resp))return;

        String dishId = req.getParameter("dishId");
        if (dishId != null) {
            dishService.remove(dishId);
            resp.getWriter().write("Dish with " + dishId + " has been deleted");
        } else {
            resp.getWriter().write("This request requires an email parameter in the path ?email=example@mail.com");
            resp.setStatus(400);
        }
    }
}




