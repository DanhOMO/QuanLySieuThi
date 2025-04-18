package DAL.DataAcessObject;

import Entity.ChucVu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ChucVuDAO extends GenericDao<ChucVu> implements ISimpleAccess<ChucVu,Integer> {

    public ChucVuDAO(EntityManager em, Class<ChucVu> clazz) {
        super(em, clazz);
    }

    public ChucVuDAO(Class<ChucVu> clazz) {
        super(clazz);
    }

    @Override
    public boolean insert(ChucVu chucVu) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(chucVu);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer maChucVu) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ChucVu cv = em.find(ChucVu.class, maChucVu);
            if (cv != null) {
                cv.setDeleted(true); // Xóa mềm
                em.merge(cv);
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
    public boolean update(Integer maChucVu, ChucVu chucVu) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ChucVu existing = em.find(ChucVu.class, maChucVu);
            if (existing != null) {
                existing.setTenChucVu(chucVu.getTenChucVu());
                existing.setMoTa(chucVu.getMoTa());
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
    public ChucVu select(Integer maChucVu) {
        String jpql = "SELECT c FROM ChucVu c WHERE c.maChucVu = :maChucVu AND c.isDeleted = false";
        return em.createQuery(jpql, ChucVu.class)
                .setParameter("maChucVu", maChucVu)
                .getSingleResult();
    }

    @Override
    public List<ChucVu> selectAll() {
        String jpql = "SELECT c FROM ChucVu c WHERE c.isDeleted = false";
        return em.createQuery(jpql, ChucVu.class).getResultList();
    }

}
