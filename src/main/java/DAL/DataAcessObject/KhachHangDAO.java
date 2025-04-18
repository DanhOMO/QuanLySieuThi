package DAL.DataAcessObject;

import Entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class KhachHangDAO extends GenericDao<KhachHang> implements ISimpleAccess<KhachHang, Integer> {

    public KhachHangDAO(EntityManager em, Class<KhachHang> clazz) {
        super(em, clazz);
    }

    public KhachHangDAO(Class<KhachHang> clazz) {
        super(clazz);
    }

    @Override
    public boolean insert(KhachHang khachHang) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Integer maKhachHang) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            KhachHang kh = em.find(KhachHang.class, maKhachHang);
            if (kh != null) {
                kh.setDeleted(true);
                em.merge(kh);
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
    public boolean update(Integer maKhachHang, KhachHang khachHang) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            khachHang.setMaKH(maKhachHang);
            em.merge(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    @Override
    public KhachHang select(Integer maKhachHang) {
        String jpql = "SELECT k FROM KhachHang k WHERE k.maKH = :maKH AND k.isDeleted = false";
        try {
            return em.createQuery(jpql, KhachHang.class)
                    .setParameter("maKH", maKhachHang)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<KhachHang> selectAll() {
        String jpql = "SELECT k FROM KhachHang k WHERE k.isDeleted = false AND k.maKH > 0";
        return em.createQuery(jpql, KhachHang.class).getResultList();
    }

    public KhachHang selectByPhoneNumber(String sdt) {
        String jpql = "SELECT k FROM KhachHang k WHERE k.soDienThoai = :sdt AND k.isDeleted = false";
        try {
            return em.createQuery(jpql, KhachHang.class)
                    .setParameter("sdt", sdt)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public KhachHang getNewestKey() {
        String jpql = "SELECT k FROM KhachHang k ORDER BY k.maKH DESC";
        try {
            return em.createQuery(jpql, KhachHang.class)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
