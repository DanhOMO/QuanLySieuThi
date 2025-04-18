package DAL.DataAcessObject;

import Utils.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public abstract class GenericDao<T> {


    // Optional: EntityManager for future use with JPA
    protected EntityManager em;
    protected Class<T> clazz;

    public GenericDao() {
        // default constructor: for JDBC usage
    }

    public GenericDao(Class<T> clazz) {
        this.em = em;
        this.clazz = clazz;
    }

    public GenericDao(EntityManager em, Class<T> clazz) {
        this.em = em;
        this.clazz = clazz;
    }
    public T findById(int id) {
        return em.find(clazz, id); // Assuming the entity has a field named 'id'
    }
    public List<T> findAll() {
       return em.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
    }
    public boolean save(T t) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(t);
            tr.commit();
            return true;
        } catch (Exception e) {
            if (tr.isActive())
                tr.rollback();
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    public boolean update(T t) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(t);
            tr.commit();
            return true;
        } catch (Exception e) {
            if (tr.isActive())
                tr.rollback();
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    public boolean delete(int id) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            T t = em.find(clazz, id);
            if (t != null) {
                em.remove(t);
                tr.commit();
                return true;
            }
            tr.rollback();
            return false;
        } catch (Exception e) {
            if (tr.isActive())
                tr.rollback();
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
