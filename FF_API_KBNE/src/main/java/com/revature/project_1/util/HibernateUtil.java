package com.revature.project_1.util;

import com.revature.project_1.Dish.Dish;
import com.revature.project_1.Order_Details.OrderDetails;
import com.revature.project_1.Orders.Order;
import com.revature.project_1.Users.User;
import com.revature.project_1.Users_Payment.UserPayment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;

    public static Session getSession() throws IOException {
        if(sessionFactory == null) {

            //Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

            Configuration configuration = new Configuration();
            Properties properties = new Properties();

            properties.load(new FileReader("src/main/resources/hibernate.properties"));


            //configuration.addAnnotatedClass(Dish.class);
            //configuration.addAnnotatedClass(OrderDetails.class);
            //configuration.addAnnotatedClass(Order.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(UserPayment.class);

            // ServiceRegistry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        if(session == null) {

            session = sessionFactory.openSession();
        }
        System.out.println(session.toString());
        return session;
    }

    public static void closeSession() {
        session.close();
        session = null;

    }
}
