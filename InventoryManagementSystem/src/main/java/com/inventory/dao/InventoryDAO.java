//package com.inventory.dao;
//
//import com.inventory.config.HibernateUtil;
//import com.inventory.model.Inventory;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import java.util.List;
//
//public class InventoryDAO {
//
//    public void saveInventory(Inventory inventory) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.save(inventory);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        }
//    }
//
//    public Inventory getInventory(int id) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.get(Inventory.class, id);
//        }
//    }
//    
//    public Inventory getInventoryByProductId(int productId) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.createQuery("FROM Inventory WHERE product.id = :productId", Inventory.class)
//                          .setParameter("productId", productId)
//                          .uniqueResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
//    public List<Inventory> getAllInventories() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.createQuery("from Inventory", Inventory.class).list();
//        }
//    }
//
//    public void updateInventory(Inventory inventory) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.update(inventory);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteInventory(int id) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            Inventory inventory = session.get(Inventory.class, id);
//            if (inventory != null) session.delete(inventory);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        }
//    }
//}

package com.inventory.dao;

import com.inventory.config.HibernateUtil;
import com.inventory.model.Inventory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class InventoryDAO {


    public void saveOrUpdateInventory(Inventory inventory) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(inventory);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }


    public Inventory getInventoryByProductId(int productId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Inventory WHERE product.id = :productId", Inventory.class)
                          .setParameter("productId", productId)
                          .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<Inventory> getAllInventories() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Inventory", Inventory.class).list();
        }
    }


    public void deleteInventoryById(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Inventory inventory = session.get(Inventory.class, id);
            if (inventory != null) session.delete(inventory);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}

