package DAL.DataAcessObject;

import Entity.NhaCungCap;
import Entity.PhieuHuy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhieuHuyDAO extends GenericDao<PhieuHuy> implements ISimpleAccess<PhieuHuy,Integer> {

    public PhieuHuyDAO(EntityManager em, Class<PhieuHuy> clazz) {
        super(em, clazz);
    }

    public PhieuHuyDAO(Class<PhieuHuy> clazz) {
        super(clazz);
    }

    @Override
    public boolean insert(PhieuHuy phieuHuy) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(phieuHuy);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer maPhieuHuy) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            PhieuHuy ph = em.find(PhieuHuy.class,maPhieuHuy );
            if (ph != null) {
                ph.setDeleted(true);
                em.merge(ph);
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
    public boolean update(Integer maPhieuHuy, PhieuHuy phieuHuy) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            PhieuHuy existing = em.find(PhieuHuy.class, maPhieuHuy);
            if (existing != null) {
                existing.setNgayLap(phieuHuy.getNgayLap());
                existing.setNhanVien(phieuHuy.getNhanVien());
                existing.setDeleted(phieuHuy.isDeleted());
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
    public PhieuHuy select(Integer maPhieuHuy) {
        String jpql = "select ph from PhieuHuy ph " +
                "where ph.maPhieu = :maPhieuHuy and ph.isDeleted = false";
        List<PhieuHuy> result = em.createQuery(jpql, PhieuHuy.class)
                .setParameter("maPhieuHuy", maPhieuHuy)
                .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<PhieuHuy> selectAll() {
        String jpql = "select ph from PhieuHuy ph " +
                "where ph.isDeleted = false";
        return em.createQuery(jpql, PhieuHuy.class)
                .getResultList();
    }

    public PhieuHuy selectNewest() {
        String jpql = "select ph from PhieuHuy ph " +
                "where ph.isDeleted = false " +
                "order by ph.ngayLap desc";
        List<PhieuHuy> result = em.createQuery(jpql, PhieuHuy.class)
                .setMaxResults(1)
                .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }


    public List<PhieuHuy> selectAndFilter(String maNV, String maPN, String ngayBD, String ngayKT){
        StringBuilder jpql = new StringBuilder("SELECT ph FROM PhieuHuy ph WHERE ph.isDeleted = false");
        Map<String, Object> params = new HashMap<>();

        jpql.append(" AND p.ngayLap >= :ngayBD AND p.ngayLap <= :ngayKT");
        params.put("ngayBD", LocalDate.parse(ngayBD));
        params.put("ngayKT", LocalDate.parse(ngayKT));

        if (!maPN.isEmpty()) {
            jpql.append(" AND p.maPhieu = :maPN");
            params.put("maPN", maPN);
        }

        if (!maNV.isEmpty()) {
            try {
                int maNVConvert = Integer.parseInt(maNV);
                jpql.append(" AND p.nhanVien.maNV = :maNV");
                params.put("maNV", maNVConvert);
            } catch (NumberFormatException e) {
                jpql.append(" AND LOWER(p.nhanVien.tenNV) LIKE :tenNV");
                params.put("tenNV", "%" + maNV.toLowerCase() + "%");
            }
        }

        TypedQuery<PhieuHuy> query = em.createQuery(jpql.toString(), PhieuHuy.class);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.getResultList();
    }
}
