package com.quanlysieuthi.quanlysieuthimini.entity;

import com.quanlysieuthi.quanlysieuthimini.enumClass.ChucVu;
import com.quanlysieuthi.quanlysieuthimini.enumClass.GioiTinh;
import com.quanlysieuthi.quanlysieuthimini.enumClass.TrangThaiNhanVien;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "NhanVien")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NhanVien {
    @Id
    @Column(name = "maNhanVien", columnDefinition = "nvarchar(45)", unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String maNhanVien;

    @Column(name = "hoTen", columnDefinition = "nvarchar(100)", nullable = false)
    private String hoTen;

    @Column(name = "sdt", columnDefinition = "nvarchar(15)", nullable = false)
    private String sdt;

    @Column(name = "diaChi", columnDefinition = "nvarchar(200)", nullable = true)
    private String diaChi;

    @Column(name = "cccd", columnDefinition = "nvarchar(20)", unique = true, nullable = false)
    private String cccd;

    @Column(name = "ngaySinh", columnDefinition = "Date", nullable = false)
    private LocalDate ngaySinh;

    @Enumerated(EnumType.STRING)
    @Column(name = "gioiTinh", columnDefinition = "nvarchar(10)", nullable = false)
    private GioiTinh gioiTinh;

    @Enumerated(EnumType.STRING)
    @Column(name = "chucVu", columnDefinition = "nvarchar(45)", nullable = false)
    private ChucVu chucVu;

    @Enumerated(EnumType.STRING)
    @Column(name = "trangThai", columnDefinition = "nvarchar(45)", nullable = false)
    private TrangThaiNhanVien trangThai;

    @OneToOne(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    private TaiKhoan taiKhoan;
}
