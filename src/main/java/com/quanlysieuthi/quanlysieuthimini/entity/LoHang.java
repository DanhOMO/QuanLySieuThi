package com.quanlysieuthi.quanlysieuthimini.entity;

import java.math.BigDecimal;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "LoHang")
public class LoHang {
    @ManyToOne
    @JoinColumn(name = "maKhoHang", nullable = false)
    private KhoHang khoHang;
    @ManyToOne
    @JoinColumn(name = "maDonNhap", nullable = false)
    private DonNhapHang donNhapHang;
    private int soLuong;
    private BigDecimal giaNhap;
    private SanPham sanPham;
}
