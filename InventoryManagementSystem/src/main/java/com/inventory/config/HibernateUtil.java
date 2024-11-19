package com.inventory.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inventory.model.Product;

public class HibernateUtil {
    // Static SessionFactory instance
    private static final SessionFactory sessionFactory = buildSessionFactory();

    // Build SessionFactory from hibernate.cfg.xml configuration file
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure we log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Provide global access to the SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Close caches and connection pools
    public static void shutdown() {
        // Close caches and connection pools
    	if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
            System.out.println("SessionFactory closed.");
        }
//        getSessionFactory().close();
    }
}
