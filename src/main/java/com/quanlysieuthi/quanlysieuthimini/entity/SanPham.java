package com.quanlysieuthi.quanlysieuthimini.entity;

import com.quanlysieuthi.quanlysieuthimini.enumClass.TrangThaiSanPham;

import java.util.Date;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private Date ngaySanXuat;
    private Date hanSuDung;
    private TrangThaiSanPham trangThai ;
    private String ghiChu;
    private String moTa;
    private double thue;

    private LoaiSanPham loaiSanPham;

    private NhaCungCap nhaCungCap;
}
