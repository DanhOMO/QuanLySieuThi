package com.quanlysieuthi.quanlysieuthimini.dao;

import com.quanlysieuthi.quanlysieuthimini.entity.TaiKhoan;
import com.quanlysieuthi.quanlysieuthimini.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class TaiKhoanDao {

    // thêm tài khoản
    public boolean themTaiKhoan(TaiKhoan taiKhoan) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.persist(taiKhoan);

            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
    // xóa tài khoản
    public void xoaTaiKhoan(TaiKhoan taiKhoan) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.remove(taiKhoan);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    // cập nhật tài khoản
    public void capNhatTaiKhoan(TaiKhoan taiKhoan) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.merge(taiKhoan);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    // Lấy toàn bộ danh sách tài khoản
    public List<TaiKhoan> layToanBoTaiKhoan() {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.createQuery("from TaiKhoan", TaiKhoan.class)
                .getResultList();
    }
}
