package com.quanlysieuthi.quanlysieuthimini.dao;

import com.quanlysieuthi.quanlysieuthimini.entity.KhuyenMai;
import com.quanlysieuthi.quanlysieuthimini.entity.NhanVien;
import com.quanlysieuthi.quanlysieuthimini.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class KhuyenMaiDao {
    // thêm khuyến mãi
    public boolean themKhuyenMai(KhuyenMai khuyenMai) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.persist(khuyenMai);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    // cap nhat khuyen mai

    public void capNhatKhuyenMai(KhuyenMai khuyenMai) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.merge(khuyenMai);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();

        } finally {
            em.close();
        }
    }

    // lấy toàn bộ danh sách khuyến mãi
    public List<KhuyenMai> layToanBoKhuyenMai() {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.createQuery("from KhuyenMai", KhuyenMai.class).getResultList();
    }
    // tìm khuyến mãi theo mã khuyến mãi
    public KhuyenMai layKhuyenMaiTheoMaKhuyenMai(String maKhuyenMai) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.createQuery("from KhuyenMai where maKhuyenMai = :maKhuyenMai", KhuyenMai.class)
                .setParameter("maKhuyenMai", maKhuyenMai)
                .getSingleResult();
    }
    // tìm khuyến mãi theo ngayBatDau
    public KhuyenMai layKhuyenMaiTheoNgayBatDau(String ngayBatDau) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.createQuery("from KhuyenMai where ngayBatDau = :ngayBatDau", KhuyenMai.class)
                .setParameter("ngayBatDau", ngayBatDau)
                .getSingleResult();
    }
    //tìm khuyến mãi theo ngayKetThuc
    public KhuyenMai layKhuyenMaiTheoNgayKetThuc(String ngayKetThuc) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.createQuery("from KhuyenMai where ngayKetThuc = :ngayKetThuc", KhuyenMai.class)
                .setParameter("ngayKetThuc", ngayKetThuc)
                .getSingleResult();
    }



}
