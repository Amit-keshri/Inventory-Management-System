//package com.inventory.service;
//
//import com.inventory.dao.InventoryDAO;
//import com.inventory.model.Inventory;
//import java.util.List;
//
//public class InventoryService {
//    private InventoryDAO inventoryDAO = new InventoryDAO();
//
//    public void createInventory(Inventory inventory) {
//        inventoryDAO.saveInventory(inventory);
//    }
//
//    public Inventory getInventoryById(int id) {
//        return inventoryDAO.getInventory(id);
//    }
//    public Inventory getInventoryByProductId(int productId) {
//        return inventoryDAO.getInventoryByProductId(productId);
//    }
//
//
//    public List<Inventory> getAllInventories() {
//        return inventoryDAO.getAllInventories();
//    }
//
//    public void updateInventory(Inventory inventory) {
//        inventoryDAO.updateInventory(inventory);
//    }
//
//    public void deleteInventory(int id) {
//        inventoryDAO.deleteInventory(id);
//    }
//}

package com.inventory.service;

import com.inventory.dao.InventoryDAO;
import com.inventory.model.Inventory;

import java.util.List;

public class InventoryService {
    private final InventoryDAO inventoryDAO = new InventoryDAO();

    // Create or Update Inventory
    public void saveOrUpdateInventory(Inventory inventory) {
        inventoryDAO.saveOrUpdateInventory(inventory);
    }

    // Get Inventory by Product ID
    public Inventory getInventoryByProductId(int productId) {
        return inventoryDAO.getInventoryByProductId(productId);
    }

    // Get All Inventories
    public List<Inventory> getAllInventories() {
        return inventoryDAO.getAllInventories();
    }

    // Delete Inventory by ID
    public void deleteInventoryById(int id) {
        inventoryDAO.deleteInventoryById(id);
    }
}
