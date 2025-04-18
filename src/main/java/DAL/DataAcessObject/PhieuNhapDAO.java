package DAL.DataAcessObject;

import Entity.NhaCungCap;
import Entity.PhieuHuy;
import Entity.PhieuNhap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhieuNhapDAO extends GenericDao<PhieuNhap> implements ISimpleAccess<PhieuNhap,Integer> {

    public PhieuNhapDAO(EntityManager em, Class<PhieuNhap> clazz) {
        super(em, clazz);
    }

    public PhieuNhapDAO(Class<PhieuNhap> clazz) {
        super(clazz);
    }

    @Override
    public boolean insert(PhieuNhap phieuNhap) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(phieuNhap);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer maPhieuNhap) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            PhieuNhap pn = em.find(PhieuNhap.class,maPhieuNhap );
            if (pn != null) {
                pn.setDeleted(true);
                em.merge(pn);
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
    public boolean update(Integer maPhieuNhap, PhieuNhap phieuNhap) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            PhieuNhap existing = em.find(PhieuNhap.class, maPhieuNhap);
            if (existing != null) {
                existing.setNgayLap(phieuNhap.getNgayLap());
                existing.setNhanVien(phieuNhap.getNhanVien());
                existing.setDeleted(phieuNhap.isDeleted());
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
    public PhieuNhap select(Integer integer) {
        String jpql = "select pn from PhieuNhap pn " +
                "where pn.maPhieu = :maPhieu and pn.isDeleted = false ";
        List<PhieuNhap> list = em.createQuery(jpql, PhieuNhap.class)
                .setParameter("maPhieu", integer)
                .getResultList();
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<PhieuNhap> selectAll() {
        String jpql = "select pn from PhieuNhap pn " +
                "where pn.isDeleted = false ";
        return em.createQuery(jpql, PhieuNhap.class)
                .getResultList();
    }

    public PhieuNhap selectNewest(){
        String jpql = "select pn from PhieuNhap pn " +
                "where pn.isDeleted = false " +
                "order by pn.ngayLap desc";
        List<PhieuNhap> result = em.createQuery(jpql, PhieuNhap.class)
                .setMaxResults(1)
                .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    public List<PhieuNhap> selectAndFilter(String maNV, String maPN, String ngayBD, String ngayKT) {
        StringBuilder jpql = new StringBuilder("SELECT p FROM PhieuNhap p WHERE p.isDeleted = false");
        Map<String, Object> params = new HashMap<>();

        // Lọc theo khoảng ngày nếu có
        if (ngayBD != null && !ngayBD.isEmpty() && ngayKT != null && !ngayKT.isEmpty()) {
            LocalDate dateBD = LocalDate.parse(ngayBD);
            LocalDate dateKT = LocalDate.parse(ngayKT);
            params.put("ngayBD", Timestamp.valueOf(dateBD.atStartOfDay()));
            params.put("ngayKT", Timestamp.valueOf(dateKT.atTime(23, 59, 59)));
            jpql.append(" AND p.ngayLap BETWEEN :ngayBD AND :ngayKT");
        }

        // Lọc theo mã phiếu
        if (maPN != null && !maPN.isEmpty()) {
            jpql.append(" AND p.maPhieu = :maPN");
            params.put("maPN", maPN);
        }

        // Lọc theo mã hoặc tên nhân viên
        if (maNV != null && !maNV.isEmpty()) {
            try {
                int maNVInt = Integer.parseInt(maNV);
                jpql.append(" AND p.nhanVien.maNV = :maNV");
                params.put("maNV", maNVInt);
            } catch (NumberFormatException e) {
                jpql.append(" AND LOWER(p.nhanVien.tenNV) LIKE :tenNV");
                params.put("tenNV", "%" + maNV.toLowerCase() + "%");
            }
        }

        TypedQuery<PhieuNhap> query = em.createQuery(jpql.toString(), PhieuNhap.class);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.getResultList();
    }

    public static void main(String[] args) {
        PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO(PhieuNhap.class);
        phieuNhapDAO.selectAll().forEach(System.out::println);
    }
}
