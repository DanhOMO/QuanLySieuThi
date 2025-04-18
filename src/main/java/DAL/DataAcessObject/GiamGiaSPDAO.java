package DAL.DataAcessObject;

import Entity.GiamGiaSP;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class GiamGiaSPDAO extends GenericDao<GiamGiaSP> implements ISimpleAccess<GiamGiaSP, Integer> {

    public GiamGiaSPDAO(EntityManager em, Class<GiamGiaSP> clazz) {
        super(em, clazz);
    }

    public GiamGiaSPDAO(Class<GiamGiaSP> clazz) {
        super(clazz);
    }

    @Override
    public boolean insert(GiamGiaSP giamGiaSP) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(giamGiaSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Integer soPhieu) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            GiamGiaSP gg = em.find(GiamGiaSP.class, soPhieu);
            if (gg != null) {
                gg.setDeleted(true); // đánh dấu mềm
                em.merge(gg);
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
    public boolean update(Integer soPhieu, GiamGiaSP giamGiaSP) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            giamGiaSP.setSoPhieu(soPhieu);
            em.merge(giamGiaSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    @Override
    public GiamGiaSP select(Integer soPhieu) {
        try {
            return em.createQuery("SELECT g FROM GiamGiaSP g WHERE g.soPhieu = :soPhieu AND g.isDeleted = false", GiamGiaSP.class)
                    .setParameter("soPhieu", soPhieu)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<GiamGiaSP> selectAll() {
        return em.createQuery("SELECT g FROM GiamGiaSP g WHERE g.isDeleted = false", GiamGiaSP.class)
                .getResultList();
    }

    public GiamGiaSP selectByMaSP(Integer maSP) {
        try {
            return em.createQuery(
                            "SELECT g FROM GiamGiaSP g WHERE g.sanPham.maSP = :maSP AND g.isDeleted = false AND g.ngayKT >= CURRENT_DATE",
                            GiamGiaSP.class)
                    .setParameter("maSP", maSP)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
