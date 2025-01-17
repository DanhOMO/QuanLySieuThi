package com.quanlysieuthi.quanlysieuthimini.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KhoHang {
    private String maKhoHang;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private int soLuong;
    @OneToOne
    @JoinColumn(name = "maSanPham", nullable = false)
    private SanPham sanPham;

}
