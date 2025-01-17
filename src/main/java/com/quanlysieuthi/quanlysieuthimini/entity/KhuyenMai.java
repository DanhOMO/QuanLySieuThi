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
    @Column(name = "maKhuyenMai", columnDefinition = "nvarchar(45)", unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String maKhuyenMai;

    @Column(name = "ngayBatDau", columnDefinition = "Date", nullable = false)
    private Date ngayBatDau;

    @Column(name = "ngayKetThuc", columnDefinition = "Date", nullable = false)
    private Date ngayKetThuc;

    @Column(name = "dieuKien", columnDefinition = "Double", nullable = false)
    private Double dieuKien;

    @Column(name = "chieuKhau", columnDefinition = "Double", nullable = false)
    private Double chieuKhau;

    @ToString.Exclude
    @OneToMany(mappedBy = "khuyenMai")
    private List<HoaDon> hoaDon;
}
