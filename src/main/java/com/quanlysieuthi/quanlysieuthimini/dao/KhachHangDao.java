package com.quanlysieuthi.quanlysieuthimini.dao;

import com.quanlysieuthi.quanlysieuthimini.entity.KhachHang;
import com.quanlysieuthi.quanlysieuthimini.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class KhachHangDao {
    // thêm khách hàng
    public boolean themKhachHang(KhachHang khachHang) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.persist(khachHang);

            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // cập nhật khách hàng
    public void capNhatKhachHang(KhachHang khachHang) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.merge(khachHang);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
    // lấy toán bộ danh sách khách hàng
    public List<KhachHang> layToanBoKhachHang() {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.createQuery("from KhachHang", KhachHang.class).getResultList();
    }

    // tim khách hàng theo mã khách hàng
    public KhachHang layKhachHangTheoMaKhachHang(String maKhachHang) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.createQuery("from KhachHang where maKhachHang = :maKhachHang", KhachHang.class)
                .setParameter("maKhachHang", maKhachHang)
                .getSingleResult();
    }
    // tim khách hàng theo hoTen
    public List<KhachHang> layKhachHangTheoHoTen(String hoTen) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.createQuery("from KhachHang where hoTen like :hoTen", KhachHang.class)
                .setParameter("hoTen", "%" + hoTen + "%")
                .getResultList();
    }

}
