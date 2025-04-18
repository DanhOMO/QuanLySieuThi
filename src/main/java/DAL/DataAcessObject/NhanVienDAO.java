package DAL.DataAcessObject;



import Entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class NhanVienDAO extends GenericDao<NhanVien> implements ISimpleAccess<NhanVien,Integer>{

    public NhanVienDAO(EntityManager em, Class<NhanVien> clazz) {
        super(em,clazz);
    }

    public NhanVienDAO(Class<NhanVien> clazz) {
        super(clazz);
    }

    @Override
    public boolean insert(NhanVien nhanVien) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(nhanVien);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer maNhanVien) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            NhanVien nv = em.find(NhanVien.class,maNhanVien );
            if (nv != null) {
                nv.setDeleted(true);
                em.merge(nv);
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
    public boolean update(Integer maNhanVien, NhanVien nhanVien) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            NhanVien existing = em.find(NhanVien.class, maNhanVien);
            if (existing != null) {
                existing.setTenNV(nhanVien.getTenNV());
                existing.setGioiTinh(nhanVien.isGioiTinh());
                existing.setCmnd(nhanVien.getCmnd());
                existing.setNgaySinh(nhanVien.getNgaySinh());
                existing.setSoDienThoai(nhanVien.getSoDienThoai());
                existing.setEmail(nhanVien.getEmail());
                existing.setDiaChi(nhanVien.getDiaChi());
                existing.setNgayThamGia(nhanVien.getNgayThamGia());
                existing.setChucVu(nhanVien.getChucVu());
                existing.setDeleted(nhanVien.isDeleted());
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
    public NhanVien select(Integer maNhanVien) {
        String jpql = "select nv from NhanVien nv " +
                "where nv.maNV = :maNV and nv.isDeleted = false ";
        List<NhanVien> result = em.createQuery(jpql, NhanVien.class)
                .setParameter("maNV", maNhanVien)
                .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        String jpql = "select nv from NhanVien nv " +
                "where nv.isDeleted = false ";
        return em.createQuery(jpql, NhanVien.class)
                .getResultList();
    }

    public NhanVien selectNewest() {
        String jpql = "select nv from NhanVien nv where nv.isDeleted = false order by nv.maNV desc ";
        return em.createQuery(jpql, NhanVien.class)
                .setMaxResults(1)
                .getSingleResult();
    }

    public int getSoLuongHoaDon(int maNhanVien){
        String jpql = "select COUNT(h) from HoaDon h where h.nhanVien.maNV = :maNV";
        Long count = em.createQuery(jpql, Long.class)
                .setParameter("maNV", maNhanVien)
                .getSingleResult();
        return count.intValue();
    }

    public long getDoanhThu (int manhanvien){
        String jpql = "select SUM(h.tongTien - h.tienGiam) from HoaDon h where h.nhanVien.maNV = :maNV";
        Long count = em.createQuery(jpql, Long.class)
                .setParameter("maNV", manhanvien)
                .getSingleResult();
        return count != null ? count : 0;

    }
}
