package com.inventory.dao;

import com.inventory.config.HibernateUtil;
import com.inventory.model.Supplier;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class SupplierDAO {

    public void saveSupplier(Supplier supplier) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(supplier);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Supplier getSupplier(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Supplier.class, id);
        }
    }

    public List<Supplier> getAllSuppliers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Supplier", Supplier.class).list();
        }
    }

    public void updateSupplier(Supplier supplier) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(supplier);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteSupplier(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Supplier supplier = session.get(Supplier.class, id);
            if (supplier != null) session.delete(supplier);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
