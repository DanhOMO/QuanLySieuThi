package DAL.DataAcessObject;

import Entity.HoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import java.util.List;

public class HoaDonDAO extends GenericDao<HoaDon> implements ISimpleAccess<HoaDon, Integer> {

    public HoaDonDAO(EntityManager em, Class<HoaDon> clazz) {
        super(em, clazz);
    }

    public HoaDonDAO(Class<HoaDon> clazz) {
        super(clazz);
    }

    @Override
    public boolean insert(HoaDon hoaDon) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(hoaDon);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Integer maHoaDon) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            HoaDon hoaDon = em.find(HoaDon.class, maHoaDon);
            if (hoaDon != null) {
                hoaDon.setDeleted(true);
                em.merge(hoaDon);
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
    public boolean update(Integer maHoaDon, HoaDon hoaDon) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            hoaDon.setMaHD(maHoaDon); // đảm bảo khóa chính đúng
            em.merge(hoaDon);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    @Override
    public HoaDon select(Integer maHoaDon) {
        String jpql = "SELECT h FROM HoaDon h WHERE h.maHD = :maHD AND h.isDeleted = false";
        try {
            return em.createQuery(jpql, HoaDon.class)
                    .setParameter("maHD", maHoaDon)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<HoaDon> selectAll() {
        String jpql = "SELECT h FROM HoaDon h WHERE h.isDeleted = false";
        return em.createQuery(jpql, HoaDon.class).getResultList();
    }

    public HoaDon selectNewestBill() {
        String jpql = "SELECT h FROM HoaDon h ORDER BY h.maHD DESC";
        try {
            return em.createQuery(jpql, HoaDon.class)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<HoaDon> selectHoaDonTrongKhoang(String startDay, String endDay) {
        String jpql = "SELECT h FROM HoaDon h WHERE h.ngayHD BETWEEN :startDay AND :endDay AND h.isDeleted = false";
        return em.createQuery(jpql, HoaDon.class)
                .setParameter("startDay", java.sql.Date.valueOf(startDay))
                .setParameter("endDay", java.sql.Date.valueOf(endDay))
                .getResultList();
    }

    public static void main(String[] args) {
        HoaDonDAO hoaDonDAO = new HoaDonDAO(HoaDon.class);
        hoaDonDAO.selectAll().forEach(System.out::println);
    }
}
