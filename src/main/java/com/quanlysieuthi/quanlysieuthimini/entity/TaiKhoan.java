package com.quanlysieuthi.quanlysieuthimini.entity;

import com.quanlysieuthi.quanlysieuthimini.enumClass.TrangThaiTaiKhoan;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "TaiKhoan")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TaiKhoan {
    @Id
    @Column(name = "maTaiKhoan", columnDefinition = "nvarchar(45)")
    @EqualsAndHashCode.Include
    private String maTaiKhoan;

    @Column(name = "tenDangNhap", columnDefinition = "nvarchar(45)", nullable = false)
    private String tenDangNhap;

    @Column(name = "matKhau", columnDefinition = "nvarchar(45)", nullable = false)
    private String matKhau;

    @Enumerated(EnumType.STRING)
    @Column(name = "trangThai", columnDefinition = "nvarchar(45)", nullable = false)
    private TrangThaiTaiKhoan trangThai;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "maNhanVien", referencedColumnName = "maNhanVien", nullable = false)
    private NhanVien nhanVien;

// Tương tự cho các trường khác

}
