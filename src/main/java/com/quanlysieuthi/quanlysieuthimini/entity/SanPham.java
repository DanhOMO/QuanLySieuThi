package com.quanlysieuthi.quanlysieuthimini.entity;

import com.quanlysieuthi.quanlysieuthimini.enumClass.TrangThaiSanPham;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "SanPham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maSanPham", nullable = false, unique = true)
    private String maSanPham;
    private String tenSanPham;
    private Date ngaySanXuat;
    private Date hanSuDung;
    private TrangThaiSanPham trangThai;
    private String moTa;
    private double thue;

    @ManyToOne
    @JoinColumn(name = "maLoai", nullable = false)
    private LoaiSanPham loaiSanPham;

    @ManyToOne
    @JoinColumn(name = "maNhaCungCap", nullable = false)
    private NhaCungCap nhaCungCap;
}
