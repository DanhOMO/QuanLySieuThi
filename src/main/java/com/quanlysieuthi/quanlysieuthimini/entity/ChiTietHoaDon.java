package com.quanlysieuthi.quanlysieuthimini.entity;

import java.math.BigDecimal;
import java.util.Set;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietHoaDon {
    private String maChiTietHoaDon;
    private int soLuong;
    private BigDecimal tongTien;
    private HoaDon hoaDon;
    private SanPham sanPham;
    private LoHang loHang;
}
