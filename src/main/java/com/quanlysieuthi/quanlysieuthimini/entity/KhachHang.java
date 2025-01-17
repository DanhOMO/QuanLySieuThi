package com.quanlysieuthi.quanlysieuthimini.entity;

import com.quanlysieuthi.quanlysieuthimini.enumClass.GioiTinh;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @Column(name = "maKhachHang", columnDefinition = "nvarchar(45)", unique = true, nullable = false)
    private String maKhachHang;

    @Column(name = "hoTen", columnDefinition = "nvarchar(100)", nullable = false)
    private String hoTen;

    @Column(name = "sdt", columnDefinition = "nvarchar(15)", nullable = false)
    private String sdt;

    @Column(name = "diaChi", columnDefinition = "nvarchar(200)", nullable = true)
    private String diaChi;

    @Column(name = "cccd", columnDefinition = "nvarchar(20)", unique = true, nullable = false)
    private String cccd;

    @Enumerated(EnumType.STRING)
    @Column(name = "gioiTinh", columnDefinition = "nvarchar(10)", nullable = false)
    private GioiTinh gioiTinh;

    @Column(name = "ngaySinh", columnDefinition = "Date", nullable = false)
    private LocalDate ngaySinh;

    @Column(name = "diemTichLuy", columnDefinition = "int", nullable = false)
    private int diemTichLuy;
    @ToString.Exclude
    @OneToMany
    private List<HoaDon> hoaDon;
}
