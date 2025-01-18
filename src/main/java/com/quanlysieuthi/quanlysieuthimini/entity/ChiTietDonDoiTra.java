package com.quanlysieuthi.quanlysieuthimini.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ChiTietDonDoiTra")
public class ChiTietDonDoiTra {
    @Id
    private String maChiTietDonDoiTra;
    private int soLuong;
    private double giaBan;

    @ManyToOne
    @JoinColumn(name = "maDonDoiTra")
    private DonDoiTra donDoiTra;  // Đảm bảo tên trường này là "donDoiTra" (chứ không phải maDonDoiTra)

    @ManyToOne
    @JoinColumn(name = "maSanPham")
    private SanPham sanPham;
}
