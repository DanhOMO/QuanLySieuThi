package com.quanlysieuthi.quanlysieuthimini.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity // Đánh dấu là entity
@Table(name = "DonNhapHang") // Tên bảng trong cơ sở dữ liệu
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DonNhapHang {

    @Id
    @Column(name = "maDonNhap", nullable = false) // Khóa chính
    private String maDonNhap; // Quản lý thủ công (không tự động tăng)

    @Column(name = "ngayNhap", nullable = false)
    private LocalDate ngayNhap;

    @ManyToOne
    @JoinColumn(name = "maNhanVien", nullable = false) // Khóa ngoại tới bảng NhanVien
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "maNhaCungCap", nullable = false) // Khóa ngoại tới bảng NhaCungCap
    private NhaCungCap nhaCungCap;
}
