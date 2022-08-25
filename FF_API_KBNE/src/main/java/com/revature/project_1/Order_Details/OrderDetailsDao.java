package com.revature.project_1.Order_Details;

import com.revature.project_1.Order_Details.DTO.response.ODResponse;
import com.revature.project_1.Orders.Order;
import com.revature.project_1.util.HibernateUtil;
import com.revature.project_1.util.interfaces.Crudable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

//use UUID FOR IDS
public class OrderDetailsDao implements Crudable<OrderDetails> {

    @Override
    public OrderDetails findById(String id) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            OrderDetails order = session.get(OrderDetails.class, Integer.parseInt(id));
            transaction.commit();
            return order;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }
    @Override
    public List<OrderDetails> findAll() {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            List<OrderDetails> odResponses = session.createQuery("from orderdetails").list();
            transaction.commit();
            return odResponses;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }
    @Override
    public OrderDetails create(OrderDetails details) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(details);
            transaction.commit();
            return details;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            HibernateUtil.closeSession();
        }
    }
    @Override
    public boolean delete(String id) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            OrderDetails orderDetails = session.load(OrderDetails.class, Integer.parseInt(id));
            session.remove(orderDetails);
            transaction.commit();
            return true;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
    }
    @Override
    public boolean update(OrderDetails details) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.merge(details);
            transaction.commit();
            return true;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List<ODResponse> findByOrder(String orderId) {

        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            String hql = "from orderdetails where orderId = :orderId";
            Query query = session.createQuery(hql);
            query.setParameter("orderId",orderId);
            List<ODResponse> odResponses = query.list();
            transaction.commit();
            return odResponses;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }
}
