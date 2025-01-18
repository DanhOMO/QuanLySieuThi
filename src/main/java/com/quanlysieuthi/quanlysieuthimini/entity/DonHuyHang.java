package com.quanlysieuthi.quanlysieuthimini.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DonHuyHang")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DonHuyHang {
    @Id
    @Column(name = "maDonHuyHang", nullable = false, unique = true)
    private String maDonHuyHang; // Nếu cần UUID, tự tạo giá trị cho trường này.

    @Column(name = "ngayHuy", nullable = false)
    private LocalDate ngayHuy;

    @Column(name = "soLuong", nullable = false)
    private int soLuong;

    @OneToMany(mappedBy = "donHuyHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoHang> loHang;
    @ManyToOne
    @JoinColumn(name = "maNhanVien")
    private NhanVien nhanVien;
}
