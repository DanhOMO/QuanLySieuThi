package com.quanlysieuthi.quanlysieuthimini.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;



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


}