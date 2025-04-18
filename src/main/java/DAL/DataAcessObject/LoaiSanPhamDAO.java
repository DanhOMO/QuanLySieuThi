package DAL.DataAcessObject;

import Entity.LoaiSanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class LoaiSanPhamDAO extends GenericDao<LoaiSanPham> implements ISimpleAccess<LoaiSanPham, Integer> {

    public LoaiSanPhamDAO(EntityManager em, Class<LoaiSanPham> clazz) {
        super(em, clazz);
    }

    public LoaiSanPhamDAO(Class<LoaiSanPham> clazz) {
        super(clazz);
    }

    @Override
    public boolean insert(LoaiSanPham loaiSanPham) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(loaiSanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Integer maLoaiSanPham) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            LoaiSanPham loai = em.find(LoaiSanPham.class, maLoaiSanPham);
            if (loai != null) {
                loai.setDeleted(true);
                em.merge(loai);
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(Integer maLoaiSanPham, LoaiSanPham loaiSanPham) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            loaiSanPham.setMaLoai(maLoaiSanPham);
            em.merge(loaiSanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    @Override
    public LoaiSanPham select(Integer maLoaiSanPham) {
        String jpql = "SELECT l FROM LoaiSanPham l WHERE l.maLoai = :maLoai AND l.isDeleted = false";
        try {
            return em.createQuery(jpql, LoaiSanPham.class)
                    .setParameter("maLoai", maLoaiSanPham)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<LoaiSanPham> selectAll() {
        String jpql = "SELECT l FROM LoaiSanPham l WHERE l.isDeleted = false";
        return em.createQuery(jpql, LoaiSanPham.class).getResultList();
    }
}
