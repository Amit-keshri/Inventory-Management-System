package com.inventory.service;

import com.inventory.dao.CustomerDAO;
import com.inventory.model.Customer;
import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO = new CustomerDAO();

    public void createCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    public Customer getCustomerById(int id) {
        return customerDAO.getCustomer(id);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }

    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }
}
