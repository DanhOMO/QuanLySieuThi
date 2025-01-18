package com.quanlysieuthi.quanlysieuthimini.entity;

import com.quanlysieuthi.quanlysieuthimini.enumClass.TrangThaiSanPham;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "SanPham")
public class SanPham {
    @Id
    @Column(name = "maSanPham", nullable = false, unique = true)
    private String maSanPham; // Đảm bảo kiểu dữ liệu đúng

    private String tenSanPham;
    private LocalDate ngaySanXuat; // Dùng LocalDate
    private LocalDate hanSuDung;
    private String moTa;
    private double thue;

    @Enumerated(EnumType.STRING) // Hoặc EnumType.ORDINAL tùy vào cách bạn muốn lưu enum
    private TrangThaiSanPham trangThai;

    @ManyToOne
    @JoinColumn(name = "maLoai", nullable = false)
    private LoaiSanPham loaiSanPham;


    @ManyToOne
    @JoinColumn(name = "maNhaCungCap", nullable = false)
    private NhaCungCap nhaCungCap;
}

