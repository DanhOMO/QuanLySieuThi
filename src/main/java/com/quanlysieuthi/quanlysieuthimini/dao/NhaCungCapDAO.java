package com.quanlysieuthi.quanlysieuthimini.dao;

import com.quanlysieuthi.quanlysieuthimini.entity.NhaCungCap;
import com.quanlysieuthi.quanlysieuthimini.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class NhaCungCapDAO {

    // Thêm nhà cung cấp
    public boolean themNhaCungCap(NhaCungCap nhaCungCap) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.persist(nhaCungCap);

            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật nhà cung cấp
    public void capNhatNhaCungCap(NhaCungCap nhaCungCap) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.merge(nhaCungCap);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    // Lấy tất cả nhà cung cấp
    public List<NhaCungCap> layTatCaNhaCungCap() {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.createQuery("from NhaCungCap", NhaCungCap.class).getResultList();
    }

    // Tìm nhà cung cấp theo mã
    public NhaCungCap layNhaCungCapTheoMa(String maNhaCungCap) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        return em.find(NhaCungCap.class, maNhaCungCap);
    }

    // Xóa nhà cung cấp theo mã
    public boolean xoaNhaCungCapTheoMa(String maNhaCungCap) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            NhaCungCap nhaCungCap = em.find(NhaCungCap.class, maNhaCungCap);
            if (nhaCungCap != null) {
                em.remove(nhaCungCap);
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
