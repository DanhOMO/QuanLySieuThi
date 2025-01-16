package com.quanlysieuthi.quanlysieuthimini.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class HoaDon {
    private String maHoaDon;
    private LocalDate ngayTao;
    private Double diemSuDung;
    private BigDecimal tongTien;
    private NhanVien nhanVien;
    private KhuyenMai khuyenMai;
    private KhachHang khachHang;
    private List<ChiTietHoaDon> dsChiTietHoaDon;

}
