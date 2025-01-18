package com.quanlysieuthi.quanlysieuthimini.dao;

import com.quanlysieuthi.quanlysieuthimini.entity.DonHuyHang;
import com.quanlysieuthi.quanlysieuthimini.entity.KhoHang;
import com.quanlysieuthi.quanlysieuthimini.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Collections;
import java.util.List;

public class DonHuyHangDAO {

    public static void create(DonHuyHang khoHang) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin(); // Bắt đầu transaction
            em.persist(khoHang);         // Lưu entity vào cơ sở dữ liệu
            em.getTransaction().commit(); // Commit transaction
        } catch (Exception transactionException) {
            transactionException.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Rollback nếu có lỗi
            }
        } finally {
            if (em.isOpen()) {
                em.close(); // Đóng EntityManager sau khi sử dụng
            }
        }
    }
//    public static List<DonHuyHang> findAll() {
//        EntityManager em = EntityManagerUtil.getEntityManager();
//        try  {
//
//            TypedQuery<DonHuyHang> query = em.createQuery("select a from DonHuyHang a", DonHuyHang.class);
//            return query.getResultList();
//
//        }  catch (Exception resourceException) {
//
//            resourceException.printStackTrace();
//            return Collections.emptyList();
//
//        }
//    }
//    public static DonHuyHang findById(String id) {
//        EntityManager em = EntityManagerUtil.getEntityManager();
//        try {
//
//            return em.find(KhoHang.class, maDonHuyHang);
//
//        }  catch (Exception resourceException) {
//
//            resourceException.printStackTrace();
//            return null;
//
//        }
//    }
    public static void update(DonHuyHang account) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try  {
            try{

                em.getTransaction().begin();
                em.merge(account);
                em.getTransaction().commit();

            }catch(Exception transactionException) {

                transactionException.printStackTrace();
                em.getTransaction().rollback();

            }
        }  catch (Exception resourceException) {

            resourceException.printStackTrace();

        }
    }

}
