package com.quanlysieuthi.quanlysieuthimini.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@Entity
public class DonDoiTra {
    @Id
    private String maDonDoiTra;
    private LocalDate ngayDoiTao;
    private BigDecimal tienHoan;

    @ManyToOne
    @JoinColumn(name = "maNhanVien")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "maKhuyenMai")
    private KhuyenMai khuyenMai;

    @ManyToOne
    @JoinColumn(name = "maKhachHang")
    private KhachHang khachHang;

    @OneToOne
    @JoinColumn(name = "maHoaDon", unique = true)
    private HoaDon hoaDon;

    @OneToMany(mappedBy = "donDoiTra", cascade = CascadeType.ALL) // mappedBy phải trỏ tới "donDoiTra"
    private List<ChiTietDonDoiTra> dsChiTietDonDoiTra;
}
