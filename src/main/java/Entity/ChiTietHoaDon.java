package Entity;

import DAL.DataAcessObject.HoaDonDAO;
import DAL.DataAcessObject.SanPhamDAO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "CTHOADON")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietHoaDon implements Serializable {

    @EmbeddedId
    private ChiTietHoaDonId id;

    @ManyToOne
    @MapsId("maHD")
    @JoinColumn(name = "MAHD")
    private HoaDon hoaDon;

    @ManyToOne
    @MapsId("maSP")
    @JoinColumn(name = "MASP")
    private SanPham sanPham;

    @Column(name = "SOLUONG")
    private int soLuong;

    @Column(name = "GIATIEN")
    private long giaTien;

    public ChiTietHoaDon(int maSP, int i, Integer soLuong, long giaTien) {
        SanPhamDAO sanPhamDAO = new SanPhamDAO(SanPham.class);
        HoaDonDAO hoaDonDAO = new HoaDonDAO(HoaDon.class);

        this.sanPham = sanPhamDAO.select(maSP);

        this.hoaDon = hoaDonDAO.select(i);
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "maSP=" + sanPham.getMaSP() +
                ", maHD=" + hoaDon.getMaHD() +
                ", soLuong=" + soLuong +
                ", giaTien=" + giaTien +
                '}';
    }
}
