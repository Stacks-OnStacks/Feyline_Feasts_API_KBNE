package com.revature.project_1.Orders;


import com.revature.project_1.Order_Details.DTO.response.ODResponse;
import com.revature.project_1.Orders.DTO.response.OrderResponse;
import com.revature.project_1.Users_Payment.UserPayment;
import com.revature.project_1.util.HibernateUtil;
import com.revature.project_1.util.interfaces.Crudable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;
public class OrderDao implements Crudable<Order> {



    public List<Order> findAll() {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            List<Order> orders = session.createQuery("from orders").list();
            transaction.commit();
            return orders;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public Order findById(String id) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            Order order = session.get(Order.class, Integer.parseInt(id));
            transaction.commit();
            return order;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public Order create(Order requestOrder) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(requestOrder);
            transaction.commit();
            return requestOrder;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            HibernateUtil.closeSession();
        }
    }

    public boolean update(Order foundOrder) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.merge(foundOrder);
            transaction.commit();
            return true;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public boolean delete(String order) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            Order oldOrder = session.load(Order.class, Integer.parseInt(order));
            session.remove(oldOrder);
            transaction.commit();
            return true;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List<OrderResponse> findByUserPay(String payment_id) {

        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            String hql = "from orders where payment_id = :payment_id";
            Query query = session.createQuery(hql);
            query.setParameter("payment_id",payment_id);
            List<OrderResponse> orderResponses = query.list();
            transaction.commit();
            return orderResponses;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }
}
