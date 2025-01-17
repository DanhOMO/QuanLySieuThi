package com.quanlysieuthi.quanlysieuthimini.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
    private SanPham sanPham;

}
