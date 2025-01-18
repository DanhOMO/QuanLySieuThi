package com.quanlysieuthi.quanlysieuthimini.entity;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.*;

@Entity // Đánh dấu đây là một entity
@Table(name = "KhoHang") // Liên kết với bảng KhoHang
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class KhoHang {
    @Id
    @Column(name = "maKhoHang", nullable = false)
    private String maKhoHang;

    @Column(name = "giaNhap", nullable = false)
    private BigDecimal giaNhap;

    @Column(name = "giaBan", nullable = false)
    private BigDecimal giaBan;

    @Column(name = "soLuong", nullable = false)
    private int soLuong;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maSanPham", nullable = false)
    private SanPham sanPham;
}
