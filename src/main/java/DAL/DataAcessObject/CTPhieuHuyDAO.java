package DAL.DataAcessObject;

import Entity.ChiTietPhieuHuy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class CTPhieuHuyDAO extends GenericDao<ChiTietPhieuHuy> implements ISimpleAccessDetail<ChiTietPhieuHuy, Integer, Integer> {

    public CTPhieuHuyDAO(EntityManager em, Class<ChiTietPhieuHuy> clazz) {
        super(em, clazz);
    }

    public CTPhieuHuyDAO(Class<ChiTietPhieuHuy> clazz) {
        super(clazz);
    }

    @Override
    public ChiTietPhieuHuy select(Integer maPhieu, Integer maSP) {
        String jpql = "SELECT c FROM ChiTietPhieuHuy c WHERE c.phieu.maPhieu = :maPhieu AND c.sanPham.maSP = :maSP";
        return em.createQuery(jpql, ChiTietPhieuHuy.class)
                .setParameter("maPhieu", maPhieu)
                .setParameter("maSP", maSP)
                .getSingleResult();
    }

    @Override
    public boolean insert(ChiTietPhieuHuy chiTietPhieuHuy) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(chiTietPhieuHuy);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer maPhieu, Integer maSP) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ChiTietPhieuHuy ctp = select(maPhieu, maSP);
            if (ctp != null) {
                em.remove(em.contains(ctp) ? ctp : em.merge(ctp));
                tx.commit();
                return true;
            }
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Integer maPhieu, Integer maSP, ChiTietPhieuHuy chiTietPhieuHuy) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ChiTietPhieuHuy existing = select(maPhieu, maSP);
            if (existing != null) {
                existing.setPhieu(chiTietPhieuHuy.getPhieu());
                existing.setSanPham(chiTietPhieuHuy.getSanPham());
                existing.setSoLuong(chiTietPhieuHuy.getSoLuong());
                em.merge(existing);
                tx.commit();
                return true;
            }
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public List<ChiTietPhieuHuy> selectAllById1(Integer maPhieu) {
        String jpql = "SELECT c FROM ChiTietPhieuHuy c WHERE c.phieu.maPhieu = :maPhieu";
        return em.createQuery(jpql, ChiTietPhieuHuy.class)
                .setParameter("maPhieu", maPhieu)
                .getResultList();
    }

    @Override
    public List<ChiTietPhieuHuy> selectAllById2(Integer maSP) {
        String jpql = "SELECT c FROM ChiTietPhieuHuy c WHERE c.sanPham.maSP = :maSP";
        return em.createQuery(jpql, ChiTietPhieuHuy.class)
                .setParameter("maSP", maSP)
                .getResultList();
    }

    @Override
    public List<ChiTietPhieuHuy> selectAll() {
        String jpql = "SELECT c FROM ChiTietPhieuHuy c";
        return em.createQuery(jpql, ChiTietPhieuHuy.class).getResultList();
    }

}
