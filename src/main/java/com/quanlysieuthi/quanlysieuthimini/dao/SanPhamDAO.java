package com.quanlysieuthi.quanlysieuthimini.dao;

import com.quanlysieuthi.quanlysieuthimini.entity.SanPham;
import com.quanlysieuthi.quanlysieuthimini.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class SanPhamDAO {

    // Thêm sản phẩm
    public boolean themSanPham(SanPham sanPham) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.persist(sanPham);

            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật sản phẩm
    public void capNhatSanPham(SanPham sanPham) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.merge(sanPham);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    // Lấy toàn bộ danh sách sản phẩm
    public List<SanPham> layToanBoSanPham() {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.createQuery("from SanPham", SanPham.class).getResultList();
    }

    // Tìm sản phẩm theo mã sản phẩm
    public SanPham laySanPhamTheoMaSanPham(String maSanPham) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.createQuery("from SanPham where maSanPham = :maSanPham", SanPham.class)
                .setParameter("maSanPham", maSanPham)
                .getSingleResult();
    }

    // Tìm sản phẩm theo tên
    public List<SanPham> laySanPhamTheoTen(String tenSanPham) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.createQuery("from SanPham where tenSanPham like :tenSanPham", SanPham.class)
                .setParameter("tenSanPham", "%" + tenSanPham + "%")
                .getResultList();
    }

    // Xóa sản phẩm theo mã sản phẩm
    public boolean xoaSanPham(String maSanPham) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            SanPham sanPham = em.createQuery("from SanPham where maSanPham = :maSanPham", SanPham.class)
                    .setParameter("maSanPham", maSanPham)
                    .getSingleResult();

            if (sanPham != null) {
                em.remove(sanPham);
            }

            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
