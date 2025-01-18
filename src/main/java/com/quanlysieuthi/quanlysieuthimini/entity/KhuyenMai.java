package com.quanlysieuthi.quanlysieuthimini.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name = "KhuyenMai")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class KhuyenMai {
    @Id
    @Column(name = "maKhuyenMai", length = 45, unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String maKhuyenMai;

    @Column(name = "ngayBatDau", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ngayBatDau;

    @Column(name = "ngayKetThuc", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ngayKetThuc;

    @Column(name = "dieuKien", nullable = false)
    private Double dieuKien;

    @Column(name = "chieuKhau", nullable = false)
    private Double chieuKhau;

    @ToString.Exclude
    @OneToMany(mappedBy = "khuyenMai")
    private List<HoaDon> hoaDon;
}
