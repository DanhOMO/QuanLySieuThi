/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.ManageGroup.Handle.NhanVienHandle;

import BUS.BusAccessor.NhanVienBUS;
import DAL.DataAcessObject.ChucVuDAO;
import DAL.DataAcessObject.NhanVienDAO;
import Entity.ChucVu;
import Entity.NhanVien;
import java.sql.Date;
import java.text.ParseException;

/**
 *
 * @author MY ACER
 */
public class NhanVienToData {
    NhanVienBUS nhanvienBUS = new NhanVienBUS();
    ChucVuDAO chucvuDAO = new ChucVuDAO(ChucVu.class);
    private Date ngaythamgia;
    
    public boolean AddNhanVien(String tenNhanVien, String soDienThoai, String cmnd, int gioiTinh, Date ngaySinh, String email, String diachi, Date ngayThamGia, int maChucVu) throws ParseException {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setTenNV(tenNhanVien);
        nhanVien.setSoDienThoai(soDienThoai);
        nhanVien.setCmnd(cmnd);
        boolean testGioiTinh = true;
        if(gioiTinh == 0)  testGioiTinh = false;
        nhanVien.setGioiTinh(testGioiTinh);
         System.out.println(ngaySinh);
         nhanVien.setEmail(email);
         nhanVien.setDiaChi(diachi);
         nhanVien.setNgaySinh(ngaySinh);
         nhanVien.setNgayThamGia(ngayThamGia);

          nhanVien.setChucVu(chucvuDAO.select(maChucVu));
          System.out.println(nhanVien.toString());
        return nhanvienBUS.add(nhanVien);
    }
    
    
    
}
