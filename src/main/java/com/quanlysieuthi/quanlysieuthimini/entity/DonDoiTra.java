package com.quanlysieuthi.quanlysieuthimini.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.*;

import javax.persistence.*;

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
    @JoinColumn(name = "maHoaDon", unique = true )
    private HoaDon hoaDon;

    @OneToMany(mappedBy = "donDoiTra", cascade = CascadeType.ALL)
    private List<ChiTietDonDoiTra> dsChiTietDonDoiTra;

}
