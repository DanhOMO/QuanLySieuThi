package DAL.DataAcessObject;

import Entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class TaiKhoanDAO extends GenericDao<TaiKhoan> implements ISimpleAccess<TaiKhoan, Integer> {

    public TaiKhoanDAO(EntityManager em, Class<TaiKhoan> clazz) {
        super(em, clazz);
    }

    public TaiKhoanDAO(Class<TaiKhoan> clazz) {
        super(clazz);
    }

    @Override
    public boolean insert(TaiKhoan taiKhoan) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(taiKhoan);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Integer soTaiKhoan) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            TaiKhoan tk = em.find(TaiKhoan.class, soTaiKhoan);
            if (tk != null) {
                tk.setDeleted(true);
                em.merge(tk);
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
    public boolean update(Integer soTaiKhoan, TaiKhoan taiKhoan) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            taiKhoan.setSoTK(soTaiKhoan);
            em.merge(taiKhoan);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    @Override
    public TaiKhoan select(Integer soTaiKhoan) {
        String sql = "SELECT T FROM TaiKhoan T WHERE T.soTK = :soTK AND T.isDeleted = false";
        return em.createQuery(sql, TaiKhoan.class)
                .setParameter("soTK", soTaiKhoan)
                .getSingleResult();
    }

    @Override
    public List<TaiKhoan> selectAll() {
        String sql = "SELECT T FROM TaiKhoan T WHERE T.isDeleted = false";
        return em.createQuery(sql, TaiKhoan.class).getResultList();
    }

    public TaiKhoan selectByTenTK(String username) {
        String sql = "SELECT T FROM TaiKhoan T WHERE T.tenTK = :username AND T.isDeleted = false";
        return em.createQuery(sql, TaiKhoan.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}
