package com.quanlysieuthi.quanlysieuthimini.entity;

import com.quanlysieuthi.quanlysieuthimini.enumClass.GioiTinh;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
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
