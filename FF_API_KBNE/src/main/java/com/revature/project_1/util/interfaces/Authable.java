package com.revature.project_1.util.interfaces;

import com.revature.project_1.Users.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface Authable {

    default boolean checkAuth(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("authUser") == null){
            resp.getWriter().write("Unauthorized request - not logged in as a registered member");
            resp.setStatus(401);
            return false;
        }
        return true;
    }

    // here's another version if you had a hypothetical admin user
    default boolean checkAdmin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("authUser");
        if(!user.isAdmin()){
            resp.getWriter().write("Unauthorized request - not logged in as an admin");
            resp.setStatus(401);
            return false;
        }
        return true;
    }

}
