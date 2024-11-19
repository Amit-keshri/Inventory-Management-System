//package com.inventory.dao;
//
//import com.inventory.config.HibernateUtil;
//import com.inventory.model.OrderDetail;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import java.util.List;
//
//public class OrderDetailDAO {
//
//    public void saveOrderDetail(OrderDetail orderDetail) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.save(orderDetail);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        }
//    }
//    
////    Transaction transaction = null;
////    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
////        transaction = session.beginTransaction();
////        
////        // Ensure relationships are set correctly before saving
////        if (product.getCategory() == null || product.getSupplier() == null) {
////            throw new IllegalArgumentException("Category and Supplier must not be null.");
////        }
////        
////        session.save(product);
////        transaction.commit();
////    } catch (Exception e) {
////        if (transaction != null) transaction.rollback();
////        e.printStackTrace();
////    }
//
//    public OrderDetail getOrderDetail(int id) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.get(OrderDetail.class, id);
//        }
//    }
//
//    public List<OrderDetail> getAllOrderDetails() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.createQuery("from OrderDetail", OrderDetail.class).list();
//        }
//    }
//
//    public void updateOrderDetail(OrderDetail orderDetail) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.update(orderDetail);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteOrderDetail(int id) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            OrderDetail orderDetail = session.get(OrderDetail.class, id);
//            if (orderDetail != null) session.delete(orderDetail);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        }
//    }
//}
//

package com.inventory.dao;

import com.inventory.model.OrderDetail;
import com.inventory.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderDetailDAO {
    public void createOrderDetail(OrderDetail orderDetail) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(orderDetail);
            transaction.commit();
        }
    }

    public OrderDetail getOrderDetailById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(OrderDetail.class, id);
        }
    }

    public List<OrderDetail> getAllOrderDetails() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from OrderDetail", OrderDetail.class).list();
        }
    }

    public void updateOrderDetail(OrderDetail orderDetail) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(orderDetail);
            transaction.commit();
        }
    }

    public void deleteOrderDetail(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            OrderDetail orderDetail = session.get(OrderDetail.class, id);
            if (orderDetail != null) {
                session.delete(orderDetail);
            }
            transaction.commit();
        }
    }
}

