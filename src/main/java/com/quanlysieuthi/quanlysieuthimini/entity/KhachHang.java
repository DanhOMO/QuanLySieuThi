package com.quanlysieuthi.quanlysieuthimini.entity;

import com.quanlysieuthi.quanlysieuthimini.enumClass.GioiTinh;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@Entity
public class KhachHang {
    @Id
    private String maKhachHang;
    private String hoTen;
    private String sdt;
    private String diaChi;
    private String cccd;
    private GioiTinh gioiTinh;
    private LocalDate ngaySinh;
    private int diemTichLuy;

}
