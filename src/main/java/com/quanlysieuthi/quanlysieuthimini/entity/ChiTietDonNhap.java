package com.quanlysieuthi.quanlysieuthimini.entity;

import java.math.BigDecimal;
import java.util.Set;

public class ChiTietDonNhap {
    private String maChiTietDonNhap;
    private Set<SanPham> maSanPham;
    private int soLuong;
    private BigDecimal giaNhap;
    private Set<DonNhapHang> donNhapHang;
}
