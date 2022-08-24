package com.revature.project_1.util.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project_1.Users.User;
import com.revature.project_1.Users.UserService;
import com.revature.project_1.util.web.DTO.LoginCreds;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthServlet extends HttpServlet {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    // Dependency Injection
    public AuthServlet(UserService userService, ObjectMapper objectMapper){
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("test");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginCreds loginCreds = objectMapper.readValue(req.getInputStream(), LoginCreds.class); // this provides the body from the request as a JSON, leveraging Reflections

        User user = userService.login(loginCreds.getUsername(), loginCreds.getPassword());

        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("authUser", user);

        resp.getWriter().write("Welcome back to FF " + user.getUsername());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate(); // this is how you kill/delete/logout of the session/cookie
        resp.getWriter().write("User has successfully logged out");
    }
}

