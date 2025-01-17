package com.quanlysieuthi.quanlysieuthimini.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "DonNhapHang")
public class DonNhapHang {
    @Id
    private String maDonNhap;
    private LocalDate ngayNhap;
    @ManyToOne
    @JoinColumn( name = "maNhanVien", nullable = false)
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn( name = "maNhaCungCap", nullable = false)
    private NhaCungCap nhaCungCap;
}
