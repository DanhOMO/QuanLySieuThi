package com.quanlysieuthi.quanlysieuthimini.entity;

import java.math.BigDecimal;
import java.util.Set;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class ChiTietHoaDon {
    @Id
    private String maChiTietHoaDon;
    private int soLuong;
    private BigDecimal tongTien;

    @ManyToOne
    @JoinColumn(name = "maHoaDon")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "maSanPham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "maLoHang")
    private LoHang loHang;
}
