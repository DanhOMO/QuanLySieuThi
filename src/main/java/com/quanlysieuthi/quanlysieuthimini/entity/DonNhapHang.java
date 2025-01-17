package com.quanlysieuthi.quanlysieuthimini.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
    private NhanVien nhanVien;
    @ManyToOne
    private NhaCungCap nhaCungCap;
}
