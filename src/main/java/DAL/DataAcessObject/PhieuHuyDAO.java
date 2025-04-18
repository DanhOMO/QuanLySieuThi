package DAL.DataAcessObject;

import Entity.NhaCungCap;
import Entity.PhieuHuy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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


    public List<PhieuHuy> selectAndFilter(String maNV, String maPN, String ngayBD, String ngayKT) {
        StringBuilder jpql = new StringBuilder("SELECT ph FROM PhieuHuy ph WHERE ph.isDeleted = false");
        Map<String, Object> params = new HashMap<>();

        // Xử lý ngày nếu có nhập
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");

        if (ngayBD != null && !ngayBD.isEmpty() && ngayKT != null && !ngayKT.isEmpty()) {
            LocalDate dateBD = LocalDate.parse(ngayBD , formatter);
            LocalDate dateKT = LocalDate.parse(ngayKT , formatter);
            params.put("ngayBD", java.sql.Timestamp.valueOf(dateBD.atStartOfDay()));
            params.put("ngayKT", java.sql.Timestamp.valueOf(dateKT.atTime(23, 59, 59)));
            jpql.append(" AND ph.ngayLap BETWEEN :ngayBD AND :ngayKT");
        }

        // Lọc theo mã phiếu
        if (maPN != null && !maPN.isEmpty()) {
            jpql.append(" AND ph.maPhieu = :maPN");
            params.put("maPN", maPN);
        }

        // Lọc theo nhân viên (mã hoặc tên)
        if (maNV != null && !maNV.isEmpty()) {
            try {
                int maNVInt = Integer.parseInt(maNV);
                jpql.append(" AND ph.nhanVien.maNV = :maNV");
                params.put("maNV", maNVInt);
            } catch (NumberFormatException e) {
                jpql.append(" AND LOWER(ph.nhanVien.tenNV) LIKE :tenNV");
                params.put("tenNV", "%" + maNV.toLowerCase() + "%");
            }
        }

        // Tạo query và truyền tham số
        TypedQuery<PhieuHuy> query = em.createQuery(jpql.toString(), PhieuHuy.class);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.getResultList();
    }

}
