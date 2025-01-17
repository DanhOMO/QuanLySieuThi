package com.quanlysieuthi.quanlysieuthimini.dao;

import com.quanlysieuthi.quanlysieuthimini.entity.NhanVien;
import com.quanlysieuthi.quanlysieuthimini.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class NhanVienDao {

    // thêm nhân viên
    public boolean themNhanVien(NhanVien nhanVien) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.persist(nhanVien);

            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // xóa nhân viên
    public void xoaNhanVien(NhanVien nhanVien) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.remove(nhanVien);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    // cập nhật nhân viên
    public void capNhatNhanVien(NhanVien nhanVien) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.merge(nhanVien);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    // Lấy toàn bộ danh sách nhân viên
    public List<NhanVien> layToanBoNhanVien() {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.createQuery("from NhanVien", NhanVien.class)
                .getResultList();
    }

    // Tìm nhân viên theo mã nhân viên
    public NhanVien layNhanVienTheoMaNhanVien(String maNhanVien) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.createQuery("from NhanVien where maNhanVien = :maNhanVien", NhanVien.class)
                .setParameter("maNhanVien", maNhanVien)
                .getSingleResult();
    }
    //Tìm nhân viên theo ho ten
    public List<NhanVien> layNhanVienTheoHoTen(String hoTen){
        EntityManager em = EntityManagerUtil.getEntityManager();
        return em.createQuery("from NhanVien where hoTen like :hoTen", NhanVien.class)
                .setParameter("hoTen", "%" + hoTen + "%")
                .getResultList();
    }

}
