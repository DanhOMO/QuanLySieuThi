package DAL.DataAcessObject;

import Entity.Voucher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class VoucherDAO extends GenericDao<Voucher> implements ISimpleAccess<Voucher, String> {

    public VoucherDAO(EntityManager em, Class<Voucher> clazz) {
        super(em, clazz);
    }

    public VoucherDAO(Class<Voucher> clazz) {
        super(clazz);
    }

    @Override
    public boolean insert(Voucher voucher) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(voucher);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(String maVoucher) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Voucher voucher = em.find(Voucher.class, maVoucher);
            if (voucher != null) {
                voucher.setDeleted(true);
                em.merge(voucher);
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
    public boolean update(String maVoucher, Voucher voucher) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            voucher.setMaVoucher(maVoucher); // đảm bảo khóa chính đúng
            em.merge(voucher);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    @Override
    public Voucher select(String maVoucher) {
        String jpql = "SELECT v FROM Voucher v WHERE v.maVoucher = :maVoucher AND v.isDeleted = false";
        try {
            return em.createQuery(jpql, Voucher.class)
                    .setParameter("maVoucher", maVoucher)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Trả null nếu không tìm thấy
        }
    }

    @Override
    public List<Voucher> selectAll() {
        String jpql = "SELECT v FROM Voucher v WHERE v.isDeleted = false AND v.soVoucher > 0";
        return em.createQuery(jpql, Voucher.class).getResultList();
    }
}
