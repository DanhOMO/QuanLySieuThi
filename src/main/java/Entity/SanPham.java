package Entity;

import DAL.DataAcessObject.LoaiSanPhamDAO;
import DAL.DataAcessObject.NhaCungCapDAO;
import DAL.DataAcessObject.SanPhamDAO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "SANPHAM")

public class SanPham implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "MASP")
    private int maSP;
    @Column(name = "TENSP")
    private String tenSP;
    @Column(name = "MOTA" , length = 2000)
    private String moTa;
    @Column(name = "SOLUONG")
    private int soLuong;
    @Column(name = "HINHANH")
    private String hinhAnh;
    @Column(name = "GIATIEN")
    private long giaTien;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "MALOAI")
    private LoaiSanPham loaiSanPham;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MANCC")
    private NhaCungCap nhaCungCap;
    @Column(name = "ISDELETED")
    private boolean isDeleted;
    @OneToMany(mappedBy = "sanPham")
    private List<ChiTietPhieuHuy> chiTietPhieuHuys;

    @OneToMany(mappedBy = "sanPham")
    private List<ChiTietPhieuNhap> chiTietPhieuNhaps;

    @OneToMany(mappedBy = "sanPham")
    private List<ChiTietHoaDon> hoaDons;
    @OneToMany(mappedBy = "sanPham")
    private List<GiamGiaSP> giamGiaSPs;

    public SanPham(String tenSanPham, String moTa, String url, Long aLong, int soLuong, int loai, int maNhaCC, boolean b) {
        LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO(LoaiSanPham.class);
        NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO(NhaCungCap.class);

        this.tenSP = tenSanPham;
        this.moTa = moTa;
        this.hinhAnh = url;
        this.giaTien = aLong;
        this.soLuong = soLuong;
        this.loaiSanPham =loaiSanPhamDAO.select(loai);
        this.nhaCungCap = nhaCungCapDAO.select(maNhaCC);
        this.isDeleted = b;
    }

    public SanPham(int maSP, String tenSP, int soLuong, long giaTien, String s, int soLuongDaBan) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.hinhAnh = s;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSP=" + maSP +
                ", tenSP='" + tenSP + '\'' +
                ", moTa='" + moTa + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", giaTien=" + giaTien +
                ", soLuong=" + soLuong +
                ", maLoai=" +  getLoaiSanPham().getMaLoai() +
                ", maNCC=" + nhaCungCap.getMaNCC() +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
