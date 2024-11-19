//package com.inventory.service;
//
//import com.inventory.dao.OrderDetailDAO;
//import com.inventory.model.OrderDetail;
//import java.util.List;
////import com.inventory.config.HibernateUtil;
////import org.hibernate.Session;
////import org.hibernate.Transaction;
//
//public class OrderDetailService {
//    private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
//
//    public void createOrderDetail(OrderDetail orderDetail) {
//        orderDetailDAO.saveOrderDetail(orderDetail);
//    }
//
//    public OrderDetail getOrderDetailById(int id) {
//        return orderDetailDAO.getOrderDetail(id);
//    }
//
//    public List<OrderDetail> getAllOrderDetails() {
//        return orderDetailDAO.getAllOrderDetails();
//    }
//
//    public void updateOrderDetail(OrderDetail orderDetail) {
//        orderDetailDAO.updateOrderDetail(orderDetail);
//    }
//
//    public void deleteOrderDetail(int id) {
//        orderDetailDAO.deleteOrderDetail(id);
//    }
//}


//public class OrderDetailsService {
//    public void createOrderDetails(OrderDetails orderDetails) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.save(orderDetails);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        }
//    }
//
//    public List<OrderDetails> getAllOrderDetails() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.createQuery("FROM OrderDetails", OrderDetails.class).list();
//        }
//    }
//
//    public OrderDetails getOrderDetailsById(int id) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.get(OrderDetails.class, id);
//        }
//    }
//
//    public void updateOrderDetails(OrderDetails orderDetails) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.update(orderDetails);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteOrderDetails(int id) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            OrderDetails orderDetails = session.get(OrderDetails.class, id);
//            if (orderDetails != null) {
//                session.delete(orderDetails);
//            }
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        }
//    }
//}

package com.inventory.service;

import com.inventory.dao.OrderDetailDAO;
import com.inventory.model.OrderDetail;

import java.util.List;

public class OrderDetailService {
    private final OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

    public void createOrderDetail(OrderDetail orderDetail) {
        orderDetailDAO.createOrderDetail(orderDetail);
    }

    public OrderDetail getOrderDetailById(int id) {
        return orderDetailDAO.getOrderDetailById(id);
    }

    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailDAO.getAllOrderDetails();
    }

    public void updateOrderDetail(OrderDetail orderDetail) {
        orderDetailDAO.updateOrderDetail(orderDetail);
    }

    public void deleteOrderDetail(int id) {
        orderDetailDAO.deleteOrderDetail(id);
    }
}

