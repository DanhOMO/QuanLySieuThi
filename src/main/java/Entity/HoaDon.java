package Entity;

import DAL.DataAcessObject.KhachHangDAO;
import DAL.DataAcessObject.NhanVienDAO;
import DAL.DataAcessObject.VoucherDAO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "HOADON")
public class HoaDon implements Serializable {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "MAHD")
    private int maHD;
    @Column(name = "NGAYHD")
    private Timestamp ngayHD;
    @Column(name = "HINHTHUC")
    private String hinhThuc;
    @Column(name = "TONGTIEN")
    private long tongTien;
    @Column(name = "TIENGIAM")
    private long tienGiam;
    @ManyToOne
    @JoinColumn(name = "MANV")
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn(name = "MAKH")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "SOVOUCHER")
    private Voucher soVoucher;
    @Column(name = "ISDELETED")
    private boolean isDeleted;
    @OneToMany(mappedBy = "hoaDon")
    private List<ChiTietHoaDon> chiTietHoaDons;

    public HoaDon(Timestamp ngayHD, String hinhThuc, long tongTien, long tienGiam, NhanVien nhanVien, KhachHang khachHang, Voucher soVoucher, boolean isDeleted) {
        this.ngayHD = ngayHD;
        this.hinhThuc = hinhThuc;
        this.tongTien = tongTien;
        this.tienGiam = tienGiam;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.soVoucher = soVoucher;
        this.isDeleted = isDeleted;
    }

    public HoaDon(int i, Timestamp timestamp, String hinhthuc, long total, long l, NhanVien select, KhachHang select1, Voucher select2, boolean b) {
        this.maHD = i;
        this.ngayHD = timestamp;
        this.hinhThuc = hinhthuc;
        this.tongTien = total;
        this.tienGiam = l;
        this.nhanVien = select;
        this.khachHang = select1;
        this.soVoucher = select2;
        this.isDeleted = b;
    }
    public HoaDon(int maHD, Timestamp ngayHD, String hinhThuc, long tongTien, long tienGiam, int maKH, int maNV, String soKM, boolean isDeleted) {
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        NhanVienDAO nhanVienDAO = new NhanVienDAO(NhanVien.class);
        VoucherDAO voucherDAO = new VoucherDAO(Voucher.class);
        this.maHD = maHD;
        this.ngayHD = ngayHD;
        this.hinhThuc = hinhThuc;
        this.tongTien = tongTien;
        this.tienGiam = tienGiam;
        this.khachHang = khachHangDAO.select(maKH);
        this.nhanVien = nhanVienDAO.select(maNV);
        this.soVoucher = voucherDAO.select(soKM);
        this.isDeleted = isDeleted;
    }


    @Override
    public String toString() {
        return "HoaDon{" +
                "maHD=" + maHD +
                ", ngayHD=" + ngayHD +
                ", hinhThuc='" + hinhThuc + '\'' +
                ", tongTien=" + tongTien +
                ", tienGiam=" + tienGiam +
                ", maNV=" + nhanVien.getMaNV() +
                ", maKH=" + khachHang.getMaKH() +
                ", soKM=" + soVoucher +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
