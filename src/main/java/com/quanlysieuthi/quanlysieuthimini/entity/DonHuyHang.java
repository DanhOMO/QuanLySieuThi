package com.quanlysieuthi.quanlysieuthimini.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    private List<LoHang> loHang;
    private NhanVien nhanVien;
}
    