package com.quanlysieuthi.quanlysieuthimini.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import lombok.*;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoHang {
    private String maLo;
    private LocalDate ngaySanXuat;
    private BigDecimal giaNhap;
    private int soLuong;
    private String viTri;
    private List<SanPham> sanPham;

}
