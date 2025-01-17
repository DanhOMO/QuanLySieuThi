package com.quanlysieuthi.quanlysieuthimini.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "LoaiSanPham")
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLoai", nullable = false, unique = true)
    private String maLoai;
    private String tenLoai;

    @OneToMany(mappedBy = "loaiSanPham")
    private Set<SanPham> sanPhams;
}
