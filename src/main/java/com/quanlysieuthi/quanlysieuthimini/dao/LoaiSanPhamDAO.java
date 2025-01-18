package com.quanlysieuthi.quanlysieuthimini.dao;

import com.quanlysieuthi.quanlysieuthimini.entity.LoaiSanPham;
import com.quanlysieuthi.quanlysieuthimini.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class LoaiSanPhamDAO {

    // Thêm loại sản phẩm
    public boolean themLoaiSanPham(LoaiSanPham loaiSanPham) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.persist(loaiSanPham);

            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật loại sản phẩm
    public void capNhatLoaiSanPham(LoaiSanPham loaiSanPham) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.merge(loaiSanPham);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    // Lấy tất cả loại sản phẩm
    public List<LoaiSanPham> layTatCaLoaiSanPham() {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.createQuery("from LoaiSanPham", LoaiSanPham.class).getResultList();
    }

    // Tìm loại sản phẩm theo mã
    public LoaiSanPham layLoaiSanPhamTheoMa(String maLoaiSanPham) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.find(LoaiSanPham.class, maLoaiSanPham);
    }

    // Xóa loại sản phẩm theo mã
    public boolean xoaLoaiSanPhamTheoMa(String maLoaiSanPham) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            LoaiSanPham loaiSanPham = em.find(LoaiSanPham.class, maLoaiSanPham);
            if (loaiSanPham != null) {
                em.remove(loaiSanPham);
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                return false;
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
