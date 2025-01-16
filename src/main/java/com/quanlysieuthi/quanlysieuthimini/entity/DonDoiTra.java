package com.quanlysieuthi.quanlysieuthimini.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DonDoiTra {
    private String maDonDoiTra;
    private LocalDate ngayDoiTao;
    private BigDecimal tienHoan;
    private NhanVien nhanVien;
    private KhuyenMai khuyenMai;
    private KhachHang khachHang;
    private HoaDon hoaDon;

}
