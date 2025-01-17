package com.quanlysieuthi.quanlysieuthimini.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity

public class ChiTietDonDoiTra {
    @Id
    private String maChiTietDonDoiTra;
    private int soLuong;
    private double giaBan;

    @ManyToOne
    @JoinColumn(name = "maDonDoiTra")
    private DonDoiTra maDonDoiTra;

    @ManyToOne
    @JoinColumn(name = "maSanPham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "maLoHang")
    private LoHang loHang;
}
