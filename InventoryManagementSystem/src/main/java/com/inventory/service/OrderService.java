package com.inventory.service;

import com.inventory.dao.OrderDAO;
import com.inventory.model.Order;
import java.util.List;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();

    public void createOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    public Order getOrderById(int id) {
        return orderDAO.getOrder(id);
    }

    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);
    }

    public void deleteOrder(int id) {
        orderDAO.deleteOrder(id);
    }
}
