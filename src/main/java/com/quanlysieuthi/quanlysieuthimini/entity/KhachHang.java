package com.quanlysieuthi.quanlysieuthimini.entity;

import com.quanlysieuthi.quanlysieuthimini.enumClass.GioiTinh;

import java.time.LocalDate;
@Entity
public class KhachHang {
    @Id
    private String maKhachHang;
    private String hoTen;
    private String sdt;
    private String diaChi;
    private String cccd;
    private GioiTinh gioiTinh;
    private LocalDate ngaySinh;
    private int diemTichLuy;

}
