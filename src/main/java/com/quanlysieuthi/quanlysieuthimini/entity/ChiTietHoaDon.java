package com.quanlysieuthi.quanlysieuthimini.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ChiTietHoaDon")
public class ChiTietHoaDon {
    @Id
    private String maChiTietHoaDon;

    private int soLuong;
    private BigDecimal tongTien;

    @jakarta.persistence.ManyToOne
    @jakarta.persistence.JoinColumn(name = "maHoaDon")
    private HoaDon hoaDon;

    @jakarta.persistence.ManyToOne
    @jakarta.persistence.JoinColumn(name = "maSanPham")
    private SanPham sanPham;


}