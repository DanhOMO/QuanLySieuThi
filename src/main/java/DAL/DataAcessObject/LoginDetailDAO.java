package DAL.DataAcessObject;

import Entity.LoginDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class LoginDetailDAO extends GenericDao<LoginDetail> implements ISimpleAccess<LoginDetail, Integer> {

    public LoginDetailDAO(EntityManager em, Class<LoginDetail> clazz) {
        super(em, clazz);
    }

    public LoginDetailDAO(Class<LoginDetail> clazz) {
        super(clazz);
    }

    @Override
    public boolean insert(LoginDetail loginDetail) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(loginDetail);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Integer loginId) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            LoginDetail login = em.find(LoginDetail.class, loginId);
            if (login != null) {
                em.remove(login);
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
    public boolean update(Integer loginId, LoginDetail loginDetail) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            loginDetail.setLoginId(loginId);
            em.merge(loginDetail);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    @Override
    public LoginDetail select(Integer loginId) {
        return em.find(LoginDetail.class, loginId);
    }

    @Override
    public List<LoginDetail> selectAll() {
        return em.createQuery("SELECT l FROM LoginDetail l", LoginDetail.class).getResultList();
    }

    public LoginDetail selectByNewestSoTK(int soTK) {
        String jpql = "SELECT l FROM LoginDetail l WHERE l.taiKhoan.soTK = :soTK ORDER BY l.logoutTime DESC";
        try {
            return em.createQuery(jpql, LoginDetail.class)
                    .setParameter("soTK", soTK)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public LoginDetail selectByAuthKey(String authKey) {
        String jpql = "SELECT l FROM LoginDetail l WHERE l.authKey = :authKey AND l.logoutTime >= CURRENT_TIMESTAMP";
        try {
            return em.createQuery(jpql, LoginDetail.class)
                    .setParameter("authKey", authKey)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
