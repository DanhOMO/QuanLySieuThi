package DAL.DataAcessObject;

import Entity.NhaCungCap;
import Entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class NhaCungCapDAO extends GenericDao<NhaCungCap> implements ISimpleAccess<NhaCungCap,Integer> {

   public NhaCungCapDAO(EntityManager em, Class<NhaCungCap> clazz) {
        super(em,clazz);
    }
    public NhaCungCapDAO(Class<NhaCungCap> clazz) {
        super(clazz);
    }

    @Override
    public boolean insert(NhaCungCap nhaCungCap) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(nhaCungCap);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer maNhaCungCap) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            NhaCungCap ncc = em.find(NhaCungCap.class,maNhaCungCap );
            if (ncc != null) {
                ncc.setDeleted(true);
                em.merge(ncc);
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
    public boolean update(Integer maNhaCungCap, NhaCungCap nhaCungCap) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            NhaCungCap existing = em.find(NhaCungCap.class, maNhaCungCap);
            if (existing != null) {
                existing.setTenNCC(nhaCungCap.getTenNCC());
                existing.setDiaChi(nhaCungCap.getDiaChi());
                existing.setSdt(nhaCungCap.getSdt());
                existing.setEmail(nhaCungCap.getEmail());
                existing.setDeleted(nhaCungCap.isDeleted());
                existing.setSanPhams(nhaCungCap.getSanPhams());
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
    public NhaCungCap select(Integer maNhaCungCap) {
        String jpql = "select ncc from NhaCungCap ncc " +
                 "where ncc.maNCC = :maNCC and ncc.isDeleted = false ";
        List<NhaCungCap> result = em.createQuery(jpql, NhaCungCap.class)
                .setParameter("maNCC", maNhaCungCap)
                .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<NhaCungCap> selectAll() {
        String jpql = "select ncc from NhaCungCap ncc " +
                "where ncc.isDeleted = false ";
        return em.createQuery(jpql, NhaCungCap.class)
                .getResultList();
    }

    public NhaCungCap selectNewest() {
        String jpql = "select ncc from NhaCungCap ncc where ncc.isDeleted = false order by ncc.maNCC desc ";
        return em.createQuery(jpql, NhaCungCap.class)
                .setMaxResults(1)
                .getSingleResult();
    }

}
