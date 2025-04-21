package DAL.DataAcessObject;

import Entity.ChiTietHoaDon;
import Entity.ChiTietHoaDonId;
import Entity.HoaDon;
import Entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ChiTietHoaDonDAO extends GenericDao<ChiTietHoaDon> implements ISimpleAccessDetail<ChiTietHoaDon,Integer,Integer> {

    public ChiTietHoaDonDAO(EntityManager em, Class<ChiTietHoaDon> clazz) {
        super(em, clazz);
    }

    public ChiTietHoaDonDAO(Class<ChiTietHoaDon> clazz) {
        super(clazz);
    }

    @Override
    public ChiTietHoaDon select(Integer maHoaDon, Integer maSanPham) {
        ChiTietHoaDonId id = new ChiTietHoaDonId(maHoaDon, maSanPham);
        return em.find(ChiTietHoaDon.class, id);
    }

    @Override
    public boolean insert(ChiTietHoaDon chiTietHoaDon) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            HoaDon hoaDon = em.merge(chiTietHoaDon.getHoaDon());
            SanPham sanPham = em.merge(chiTietHoaDon.getSanPham());
            chiTietHoaDon.setHoaDon(hoaDon);
            chiTietHoaDon.setSanPham(sanPham);
            em.persist(chiTietHoaDon);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Integer maHoaDon, Integer maSanPham, ChiTietHoaDon chiTietHoaDon) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ChiTietHoaDon existing = em.find(ChiTietHoaDon.class, new ChiTietHoaDonId(maHoaDon, maSanPham));
            if (existing != null) {
                existing.setSoLuong(chiTietHoaDon.getSoLuong());
                existing.setGiaTien(chiTietHoaDon.getGiaTien());
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
    public boolean delete(Integer maHoaDon, Integer maSanPham) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ChiTietHoaDon chiTiet = em.find(ChiTietHoaDon.class, new ChiTietHoaDonId(maHoaDon, maSanPham));
            if (chiTiet != null) {
                em.remove(chiTiet);
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
    public List<ChiTietHoaDon> selectAllById1(Integer maHoaDon) {
        String jpql = "SELECT c FROM ChiTietHoaDon c WHERE c.hoaDon.maHD = :maHD";
        return em.createQuery(jpql, ChiTietHoaDon.class)
                .setParameter("maHD", maHoaDon)
                .getResultList();
    }

    @Override
    public List<ChiTietHoaDon> selectAllById2(Integer maSanPham) {
        String jpql = "SELECT c FROM ChiTietHoaDon c WHERE c.sanPham.maSP = :maSP";
        return em.createQuery(jpql, ChiTietHoaDon.class)
                .setParameter("maSP", maSanPham)
                .getResultList();
    }

    @Override
    public List<ChiTietHoaDon> selectAll() {
        String jpql = "SELECT c FROM ChiTietHoaDon c";
        return em.createQuery(jpql, ChiTietHoaDon.class).getResultList();
    }
}
