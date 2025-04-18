package DAL.DataAcessObject;

import Entity.HoaDon;

import java.util.List;

public class HoaDonDAO extends GenericDao<HoaDon> implements ISimpleAccess<HoaDon,Integer> {

    {
        setClazz(HoaDon.class);
    }

    @Override
    public boolean insert(HoaDon hoaDon) {
        return executeUpdate("INSERT INTO HOADON (NGAYHD, HINHTHUC, TONGTIEN, TIENGIAM, MANV, MAKH, SOVOUCHER, IS_DELETED) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                hoaDon.getNgayHD(), hoaDon.getHinhThuc(), hoaDon.getTongTien(), hoaDon.getTienGiam(),
                hoaDon.getNhanVien().getMaNV(), hoaDon.getKhachHang().getMaKH(), hoaDon.getSoVoucher(), hoaDon.isDeleted());
    }

    @Override
    public boolean delete(Integer maHoaDon) {
        return executeUpdate("UPDATE HOADON SET IS_DELETED = 1 WHERE MAHD = ?", maHoaDon);
    }

    @Override
    public boolean update(Integer maHoaDon, HoaDon hoaDon) {
        return executeUpdate("UPDATE HOADON SET NGAYHD = ?, HINHTHUC = ?, TONGTIEN = ?, TIENGIAM = ?, " +
                        "MANV = ?, MAKH = ?, SOVOUCHER = ?, IS_DELETED = ? WHERE MAHD = ?",
                hoaDon.getNgayHD(), hoaDon.getHinhThuc(), hoaDon.getTongTien(), hoaDon.getTienGiam(),
                hoaDon.getNhanVien().getMaNV(), hoaDon.getKhachHang().getMaKH(), hoaDon.getSoVoucher(), hoaDon.isDeleted(), maHoaDon);
    }

    @Override
    public HoaDon select(Integer maHoaDon) {
        return executeQuery("SELECT * FROM HOADON WHERE MAHD = ? AND IS_DELETED = 0", maHoaDon);
    }

    // Thay đổi cách lấy hóa đơn mới nhất
    public HoaDon selectNewestBill(){
        return executeQuery("SELECT TOP 1 * FROM HOADON ORDER BY MAHD DESC");
    }

    @Override
    public List<HoaDon> selectAll() {
        return executeQueryList("SELECT * FROM HOADON WHERE IS_DELETED = 0");
    }

    public List<HoaDon> selectHoaDonTrongKhoang(String startDay, String endDay){
        return executeQueryList("SELECT * FROM HOADON WHERE NGAYHD BETWEEN ? AND ?", startDay, endDay);
    }


}
