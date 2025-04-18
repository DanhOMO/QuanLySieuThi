package Entity;

import DAL.DataAcessObject.PhieuNhapDAO;
import DAL.DataAcessObject.SanPhamDAO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CTPHIEUNHAP")
@Data
@NoArgsConstructor
public class ChiTietPhieuNhap extends ChiTietPhieu {

    @MapsId("maPhieu")
    @ManyToOne
    @JoinColumn(name = "MAPHIEU")
    private PhieuNhap phieu;

    @MapsId("maSP")
    @ManyToOne
    @JoinColumn(name = "MASP")
    private SanPham sanPham;
    public ChiTietPhieuNhap(PhieuNhap phieuNhap, SanPham sanPham, int soLuong) {
        this.phieu = phieuNhap;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.chiTietPhieuId = new ChiTietPhieuId(phieuNhap.getMaPhieu(), sanPham.getMaSP());
    }
    public ChiTietPhieuNhap(int maPhieuNhap, int maSP, int soLuong) {
        this.soLuong = soLuong;
        PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO(PhieuNhap.class);
        SanPhamDAO sanPhamDAO = new SanPhamDAO(SanPham.class);
        this.phieu  = phieuNhapDAO.select(maPhieuNhap);
        this.sanPham = sanPhamDAO.select(maSP);
        this.chiTietPhieuId = new ChiTietPhieuId(phieu.getMaPhieu(), sanPham.getMaSP());
    }
    // Getters & Setters nếu không dùng Lombok
}
