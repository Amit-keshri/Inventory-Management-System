package com.inventory.service;

import com.inventory.dao.CategoryDAO;
import com.inventory.model.Category;
import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAO();

    public void createCategory(Category category) {
        categoryDAO.saveCategory(category);
    }

    public Category getCategoryById(int id) {
        return categoryDAO.getCategory(id);
    }

    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    public void updateCategory(Category category) {
        categoryDAO.updateCategory(category);
    }

    public void deleteCategory(int id) {
        categoryDAO.deleteCategory(id);
    }
}
