package DAL.DataAcessObject;

import Entity.ChiTietPhieuNhap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class CTPhieuNhapDAO extends GenericDao<ChiTietPhieuNhap> implements ISimpleAccessDetail<ChiTietPhieuNhap, Integer, Integer> {

    public CTPhieuNhapDAO(EntityManager em, Class<ChiTietPhieuNhap> clazz) {
        super(em, clazz);
    }

    public CTPhieuNhapDAO(Class<ChiTietPhieuNhap> clazz) {
        super(clazz);
    }

    @Override
    public ChiTietPhieuNhap select(Integer maPhieu, Integer maSP) {
        String jpql = "SELECT c FROM ChiTietPhieuNhap c WHERE c.phieu.maPhieu = :maPhieu AND c.sanPham.maSP = :maSP";
        return em.createQuery(jpql, ChiTietPhieuNhap.class)
                .setParameter("maPhieu", maPhieu)
                .setParameter("maSP", maSP)
                .getSingleResult();
    }

    @Override
    public boolean insert(ChiTietPhieuNhap chiTietPhieuNhap) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(chiTietPhieuNhap);
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
            ChiTietPhieuNhap ctpn = select(maPhieu, maSP);
            if (ctpn != null) {
                em.remove(em.contains(ctpn) ? ctpn : em.merge(ctpn));
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
    public boolean update(Integer maPhieu, Integer maSP, ChiTietPhieuNhap chiTietPhieuNhap) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ChiTietPhieuNhap existing = select(maPhieu, maSP);
            if (existing != null) {
                existing.setPhieu(chiTietPhieuNhap.getPhieu());
                existing.setSanPham(chiTietPhieuNhap.getSanPham());
                existing.setSoLuong(chiTietPhieuNhap.getSoLuong());
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
    public List<ChiTietPhieuNhap> selectAllById1(Integer maPhieu) {
        String jpql = "SELECT c FROM ChiTietPhieuNhap c WHERE c.phieu.maPhieu = :maPhieu";
        return em.createQuery(jpql, ChiTietPhieuNhap.class)
                .setParameter("maPhieu", maPhieu)
                .getResultList();
    }

    @Override
    public List<ChiTietPhieuNhap> selectAllById2(Integer maSP) {
        String jpql = "SELECT c FROM ChiTietPhieuNhap c WHERE c.sanPham.maSP = :maSP";
        return em.createQuery(jpql, ChiTietPhieuNhap.class)
                .setParameter("maSP", maSP)
                .getResultList();
    }

    @Override
    public List<ChiTietPhieuNhap> selectAll() {
        String jpql = "SELECT c FROM ChiTietPhieuNhap c";
        return em.createQuery(jpql, ChiTietPhieuNhap.class).getResultList();
    }
    
}
