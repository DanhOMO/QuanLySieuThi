package Entity;

import DAL.DataAcessObject.PhieuHuyDAO;
import DAL.DataAcessObject.PhieuNhapDAO;
import DAL.DataAcessObject.SanPhamDAO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "CTPHIEUHUY")

public class ChiTietPhieuHuy extends ChiTietPhieu {

    @MapsId("maPhieu")
    @ManyToOne
    @JoinColumn(name = "MAPHIEU")
    private PhieuHuy phieu;

    @MapsId("maSP")
    @ManyToOne
    @JoinColumn(name = "MASP")
    private SanPham sanPham;

    public ChiTietPhieuHuy() {}
    public ChiTietPhieuHuy(PhieuHuy phieu, SanPham sanPham, int soLuong) {
        this.soLuong = soLuong;
        this.phieu = phieu;
        this.sanPham = sanPham;
        this.chiTietPhieuId = new ChiTietPhieuId(phieu.getMaPhieu(), sanPham.getMaSP());
    }
    public ChiTietPhieuHuy(int maPhieuNhap, int maSP, int soLuong) {
        this.soLuong = soLuong;
        PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO(PhieuNhap.class);
        SanPhamDAO sanPhamDAO = new SanPhamDAO(SanPham.class    );
        this.phieu  = new PhieuHuyDAO(PhieuHuy.class).select(maPhieuNhap);
        this.sanPham = sanPhamDAO.select(maSP);
        this.chiTietPhieuId = new ChiTietPhieuId(phieu.getMaPhieu(), sanPham.getMaSP());
    }
}

