package com.quanlysieuthi.quanlysieuthimini.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("mariadb")
                .createEntityManager();
        System.out.println("EntityManagerFactory created successfully!");
    }
}
