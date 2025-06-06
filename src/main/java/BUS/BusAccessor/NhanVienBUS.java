/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS.BusAccessor;

import DAL.DataAcessObject.NhanVienDAO;
import Entity.HoaDon;
import Entity.NhanVien;
import java.util.List;

/**
 *
 * @author tiend
 */
public class NhanVienBUS implements IBussAccess<NhanVien, Integer>{
    private final NhanVienDAO nhanVienDAO =new  NhanVienDAO(NhanVien.class);
    

    public int getSoLuongHoaDon(int manhanvien){
        return nhanVienDAO.getSoLuongHoaDon(manhanvien);
    }

//    public int getSoLuongHoaDon(int manhanvien){
//        HoaDonBUS hoadonBUS = new HoaDonBUS();
//        int count = 0;
//        List<HoaDon> listHoadon = hoadonBUS.getAll();
//        if ( listHoadon == null  ||  listHoadon.isEmpty()) {
//            return 0;
//        }
//        for (HoaDon hoadon : listHoadon) {
//            if (hoadon.getNhanVien().getMaNV() == manhanvien) {
//                count++;
//            }
//        }
//        return count;
//    }

    public long getDoanhThu (int manhanvien){
        return nhanVienDAO.getDoanhThu(manhanvien);
    }

//    public long getDoanhThu (int manhanvien){
//        HoaDonBUS hoadonBUS = new HoaDonBUS();
//        long count = 0;
//        List<HoaDon> listHoadon = hoadonBUS.getAll();
//        if ( listHoadon == null  ||  listHoadon.isEmpty()) {
//            return 0;
//
//        }
//         for (HoaDon hoadon : listHoadon) {
//            if (hoadon.getNhanVien().getMaNV() == manhanvien) {
//               count += hoadon.getTongTien() - hoadon.getTienGiam();
//            }
//        }
//        return count;
//
//    }
    
    
    
    @Override
    public NhanVien get(Integer maNhanVien) {
        return nhanVienDAO.select(maNhanVien);
    }

    @Override
    public List<NhanVien> getAll() {
        return nhanVienDAO.selectAll();
    }

    @Override
    public boolean add(NhanVien nhanvien) {
        return nhanVienDAO.insert(nhanvien);
    }

    @Override
    public boolean edit(Integer maNhanVien, NhanVien nhanvien) {
        return nhanVienDAO.update(maNhanVien, nhanvien);
    }

    @Override
    public boolean remove(Integer maNhanVien) {
        return nhanVienDAO.delete(maNhanVien);
    }

    @Override
    public NhanVien getNewest() {
       return nhanVienDAO.selectNewest();
    }
    
}
