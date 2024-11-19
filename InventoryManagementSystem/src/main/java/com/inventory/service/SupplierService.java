package com.inventory.service;

import com.inventory.dao.SupplierDAO;
import com.inventory.model.Supplier;
import java.util.List;

public class SupplierService {
    private SupplierDAO supplierDAO = new SupplierDAO();

    public void createSupplier(Supplier supplier) {
        supplierDAO.saveSupplier(supplier);
    }

    public Supplier getSupplierById(int id) {
        return supplierDAO.getSupplier(id);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierDAO.getAllSuppliers();
    }

    public void updateSupplier(Supplier supplier) {
        supplierDAO.updateSupplier(supplier);
    }
    
//    public void updateSupplier(Supplier supplier) {
//        supplierDAO.updateSupplier(supplier);
//    }

    public void deleteSupplier(int id) {
        supplierDAO.deleteSupplier(id);
    }
}
