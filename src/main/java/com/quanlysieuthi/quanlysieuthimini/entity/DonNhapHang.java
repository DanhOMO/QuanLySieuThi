package com.quanlysieuthi.quanlysieuthimini.entity;

import java.time.LocalDate;
import java.util.Set;
import lombok.*;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DonNhapHang {
    private String maDonNhap;
    private LocalDate ngayNhap;
    private NhanVien nhanVien;
}
