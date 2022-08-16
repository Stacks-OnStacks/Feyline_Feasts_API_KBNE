package com.revature.project_1.Users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project_1.Users.DTO.requests.EditUserRequests;
import com.revature.project_1.Users.DTO.requests.NewRegistrationRequest;
import com.revature.project_1.Users.DTO.response.UserResponse;
import com.revature.project_1.util.exceptions.InvalidUserInputException;
import com.revature.project_1.util.exceptions.ResourcePersistanceException;
import com.revature.project_1.util.interfaces.Authable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//@WebServlet("/user")
public class UserServlet extends HttpServlet implements Authable {
    private final UserService userService;
    private final ObjectMapper objectMapper;
    private final Logger logger= LogManager.getLogger();

    public UserServlet(UserService userService, ObjectMapper objectMapper) {
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username= req.getParameter("username");
        User authUser= (User) req.getSession().getAttribute("authUser");

        if(username!=null){
            try{
                UserResponse user= userService.findByUsername(username);

                String payload = objectMapper.writeValueAsString(user);
                resp.getWriter().write(payload);
            }
            catch (InvalidUserInputException e){
                logger.warn("User information entered was not reflective of any user in the database. Username provided was: {}", username);
                resp.getWriter().write("Username entered was not in the database.");
                resp.setStatus(404);
            }
        }
        else {
            List<UserResponse> users = userService.readAll();

            String payload = objectMapper.writeValueAsString(users);

            resp.getWriter().write(payload);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter respWriter =resp.getWriter();
        NewRegistrationRequest user= objectMapper.readValue(req.getInputStream(), NewRegistrationRequest.class);


        try{
            logger.info("user request to add the following to the database: {}", user);
            UserResponse newUser = userService.registerUser(user);

            String payload= objectMapper.writeValueAsString(newUser);

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
        EditUserRequests editUser= objectMapper.readValue(req.getInputStream(),EditUserRequests.class);

        try {
            userService.update(editUser);
            resp.getWriter().write("User update successful");
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
        String username = req.getParameter("username");
        if(username != null){
            userService.remove(username);
            resp.getWriter().write("User with " + username + " has been deleted");
        } else {
            resp.getWriter().write("This request requires an email parameter in the path ?email=example@mail.com");
            resp.setStatus(400);
        }
    }


}
