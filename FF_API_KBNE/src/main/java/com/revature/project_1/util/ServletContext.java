package com.revature.project_1.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project_1.Dish.DishDao;
import com.revature.project_1.Dish.DishService;
import com.revature.project_1.Dish.DishServlet;
import com.revature.project_1.Users.UserDao;
import com.revature.project_1.Users.UserService;
import com.revature.project_1.Users.UserServlet;
import com.revature.project_1.util.web.AuthServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class ServletContext {
    public final void run() {
        // Dependency injection will remain

        String webappDirLocation = new File("src/main/webapp/").getAbsolutePath();
        String additionalClasses = new File("target/classes").getAbsolutePath();

        Tomcat tomcat = new Tomcat();

        try {
            StandardContext standardContext = (StandardContext) tomcat.addWebapp("/", webappDirLocation);
            WebResourceRoot resourceRoot = new StandardRoot(standardContext);
            resourceRoot.addPreResources(new DirResourceSet(resourceRoot, "/WEB-INF/classes", additionalClasses, "/")); // everything you need prior to build the application

            standardContext.setResources(resourceRoot); // at this point the tomcat server now has acces and knowledge of classes information

            // object setup
            UserDao userDao = new UserDao();
            UserService userService = new UserService(userDao);
            ObjectMapper objectMapper = new ObjectMapper();
            DishDao dishDao = new DishDao();
            DishService dishService = new DishService(dishDao);

            // tomcat.setPort(3000); // Do not change port from 8080, leave default. This is just to show you can alter the ports. BEcause certain cloud providers sometimes change their ports. they use just 80 or 8080


            tomcat.addServlet("", "UserServlet", new UserServlet( userService, objectMapper));
            standardContext.addServletMappingDecoded("/user", "UserServlet");

            tomcat.addServlet("", "AuthServlet", new AuthServlet(userService, objectMapper));
            standardContext.addServletMappingDecoded("/auth", "AuthServlet");
            tomcat.addServlet("", "DishServlet", new DishServlet(dishService, objectMapper));
            standardContext.addServletMappingDecoded("/dish", "DishServlet");

            tomcat.start(); // there is a default port on your computer for testing, 8080 this is a "developers port"
            tomcat.getServer().await();

        } catch (ServletException | LifecycleException e) {
            throw new RuntimeException(e);
        }
    }

}

