package com.quanlysieuthi.quanlysieuthimini.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "LoHang") // Tên bảng trong cơ sở dữ liệu
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Khóa chính tự động tăng
    private Long id;

    @ManyToOne
    @JoinColumn(name = "maKhoHang", nullable = false) // Cột khóa ngoại liên kết với bảng KhoHang
    private KhoHang khoHang;

    @ManyToOne
    @JoinColumn(name = "maDonNhap", nullable = false) // Cột khóa ngoại liên kết với bảng DonNhapHang
    private DonNhapHang donNhapHang;

    @Column(nullable = false)
    private int soLuong;

    @Column(nullable = false)
    private BigDecimal giaNhap;

    @ManyToOne
    @JoinColumn(name = "maSanPham", nullable = false) // Cột khóa ngoại liên kết với bảng SanPham
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "maDonHuyHang") // Cột khóa ngoại liên kết với bảng DonHuyHang
    private DonHuyHang donHuyHang; // Thuộc tính ánh xạ ngược
}
