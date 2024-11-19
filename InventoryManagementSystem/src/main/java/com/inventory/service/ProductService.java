package com.inventory.service;

import com.inventory.dao.ProductDAO;
import com.inventory.model.Product;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO = new ProductDAO();

    public void createProduct(Product product) {
        productDAO.saveProduct(product);
    }

    public Product getProductById(int id) {
        return productDAO.getProduct(id);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }
}
