package com.revature.project_1.Users_Payment;

import com.revature.project_1.util.HibernateUtil;
import com.revature.project_1.util.interfaces.Crudable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.io.IOException;
import java.util.List;

//use UUID FOR IDS
public class UserPaymentDao implements Crudable<UserPayment> {
    @Override
    public UserPayment findById(String paymentid) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            UserPayment userpay = session.get(UserPayment.class, Integer.parseInt(paymentid));
            transaction.commit();
            return userpay;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List<UserPayment> findByUsername(String username) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            String hql = "from userpayments where username = :username";
            Query query = session.createQuery(hql);
            query.setParameter("username",username);
            List<UserPayment> userpays = query.list();
            transaction.commit();
            return userpays;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }
    @Override
    public List<UserPayment> findAll() {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            List<UserPayment> userpays = session.createQuery("from userpayments").list();
            transaction.commit();
            return userpays;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }
    @Override
    public UserPayment create(UserPayment userPayment) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(userPayment);
            transaction.commit();
            return userPayment;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            HibernateUtil.closeSession();
        }
    }
    @Override
    public boolean delete(String userPay) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            UserPayment up = session.load(UserPayment.class, Integer.parseInt(userPay));
            session.remove(up);
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
    public boolean update(UserPayment foundpay) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.merge(foundpay);
            transaction.commit();
            return true;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            HibernateUtil.closeSession();
        }
    }
}
