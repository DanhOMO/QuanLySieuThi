package DAL.DataAcessObject;

import Entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class SanPhamDAO extends GenericDao<SanPham> implements ISimpleAccess<SanPham, Integer> {

    public SanPhamDAO(EntityManager em, Class<SanPham> clazz) {
        super(em, clazz);
    }

    public SanPhamDAO(Class<SanPham> clazz) {
        super(clazz);
    }

    @Override
    public boolean insert(SanPham sanPham) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(sanPham);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer maSanPham) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            SanPham sp = em.find(SanPham.class, maSanPham);
            if (sp != null) {
                sp.setDeleted(true);  // Xóa mềm
                em.merge(sp);
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
    public boolean update(Integer maSanPham, SanPham sanPham) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            SanPham existing = em.find(SanPham.class, maSanPham);
            if (existing != null) {
                existing.setTenSP(sanPham.getTenSP());
                existing.setMoTa(sanPham.getMoTa());
                existing.setSoLuong(sanPham.getSoLuong());
                existing.setHinhAnh(sanPham.getHinhAnh());
                existing.setGiaTien(sanPham.getGiaTien());
                existing.setLoaiSanPham(sanPham.getLoaiSanPham());
                existing.setNhaCungCap(sanPham.getNhaCungCap());
                existing.setDeleted(sanPham.isDeleted());
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
    public SanPham select(Integer maSanPham) {
        String sql = "SELECT S FROM SanPham S WHERE S.maSP = :maSP AND S.isDeleted = false";
        return em.createQuery(sql, SanPham.class)
                .setParameter("maSP", maSanPham)
                .getSingleResult();
    }

    public SanPham selectHide(Integer maSanPham) {
        return em.find(SanPham.class, maSanPham); // có thể thấy luôn, kể cả khi bị xoá mềm
    }

    @Override
    public List<SanPham> selectAll() {
        String sql = "SELECT S FROM SanPham S WHERE S.isDeleted = false";
        return em.createQuery(sql, SanPham.class).getResultList();
    }

    public SanPham selectNewest() {
        String sql = "SELECT S FROM SanPham S WHERE S.isDeleted = false ORDER BY S.maSP DESC";
        return em.createQuery(sql, SanPham.class)
                .setMaxResults(1)
                .getSingleResult();
    }

    public List<SanPham> selectByLoaiSP(int maLoai) {
        String sql = "SELECT S FROM SanPham S WHERE S.loaiSanPham.maLoai = :maLoai AND S.isDeleted = false";
        return em.createQuery(sql, SanPham.class)
                .setParameter("maLoai", maLoai)
                .getResultList();
    }

    public List<SanPham> selectByTenSP(String tenSP) {
        String searchStr = "%" + tenSP.trim().toLowerCase() + "%";
        String sql = "SELECT S FROM SanPham S WHERE LOWER(S.tenSP) LIKE :tenSP AND S.isDeleted = false";
        return em.createQuery(sql, SanPham.class)
                .setParameter("tenSP", searchStr)
                .getResultList();
    }

    public List<SanPham> selectTenHayMoTa(String findKey) {
        String searchStr = "%" + findKey.trim().toLowerCase() + "%";
        String sql = "SELECT S FROM SanPham S WHERE (LOWER(S.tenSP) LIKE :key OR LOWER(S.moTa) LIKE :key) AND S.isDeleted = false";
        return em.createQuery(sql, SanPham.class)
                .setParameter("key", searchStr)
                .getResultList();
    }

    public List<SanPham> selectByNhaCungCap(String maNCC) {
        try {
            int maNCCint = Integer.parseInt(maNCC);
            String sql = "SELECT S FROM SanPham S WHERE S.nhaCungCap.maNCC = :maNCC AND S.isDeleted = false";
            return em.createQuery(sql, SanPham.class)
                    .setParameter("maNCC", maNCCint)
                    .getResultList();
        } catch (NumberFormatException e) {
            System.out.println("Lỗi chuyển đổi mã NCC: " + e.getMessage());
            return null;
        }
    }

    public List<SanPham> selectByMoney(String minMoney, String maxMoney) {
        try {
            double min = Double.parseDouble(minMoney);
            double max = Double.parseDouble(maxMoney);
            String sql = "SELECT S FROM SanPham S WHERE S.giaTien BETWEEN :min AND :max AND S.isDeleted = false";
            return em.createQuery(sql, SanPham.class)
                    .setParameter("min", min)
                    .setParameter("max", max)
                    .getResultList();
        } catch (NumberFormatException e) {
            System.out.println("Lỗi chuyển đổi giá tiền: " + e.getMessage());
            return null;
        }
    }

    public List<SanPham> selectByTenSPAndLoaiSP(int maLoai, String tenSP) {
        String searchStr = "%" + tenSP.trim().toLowerCase() + "%";
        String sql = "SELECT S FROM SanPham S WHERE S.loaiSanPham.maLoai = :maLoai AND LOWER(S.tenSP) LIKE :tenSP AND S.isDeleted = false";
        return em.createQuery(sql, SanPham.class)
                .setParameter("maLoai", maLoai)
                .setParameter("tenSP", searchStr)
                .getResultList();
    }

    public List<SanPham> selectAllSanPham() {
        String sql = "SELECT S FROM SanPham S";
        return em.createQuery(sql, SanPham.class).getResultList();
    }

    public static void main(String[] args) {
        SanPhamDAO sanPhamDAO = new SanPhamDAO(SanPham.class);
        sanPhamDAO.selectAll().forEach(System.out::println);
        // Test insert
    }
}
