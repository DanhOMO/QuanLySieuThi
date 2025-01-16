package com.quanlysieuthi.quanlysieuthimini.entity;

import java.time.LocalDate;
import java.util.Set;
import lombok.*;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DonHuyHang {
    private  String maDonHuyHang;
    private LocalDate ngayHuy;
    private int soLuong;
    private Set<LoHang> loHang;
    private NhanVien nhanVien;
}
