package com.quanlysieuthi.quanlysieuthimini.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Admin 1/16/2025
 **/
public class EntityManagerUtil {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("mssql");

    public  static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}