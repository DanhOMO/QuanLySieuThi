package Entity;

import DAL.DataAcessObject.ChucVuDAO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "NHANVIEN")
public class NhanVien implements Serializable
{
//    MANV
private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="MANV")
    private int maNV;
    @Column(name = "TENNV" )
    private String tenNV;
    @Column(name = "GIOITINH")
    private boolean gioiTinh;
    @Column(name = "CMND")
    private String cmnd;
    @Column(name = "NGAYSINH")
    private Date ngaySinh;
    @Column(name = "SODIENTHOAI")
    private String soDienThoai;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DIACHI")
    private String diaChi;
    @Column(name = "NGAYTHAMGIA")
    private Date ngayThamGia;
    @ManyToOne
    @JoinColumn(name = "MACHUCVU")
    private ChucVu chucVu;
    @Column(name = "ISDELETED")
    private boolean isDeleted;
    @OneToMany(mappedBy = "nhanVien")
    private List<TaiKhoan> taiKhoans;
    @OneToMany(mappedBy = "nhanVien")
    private List<HoaDon> hoaDons;
    @OneToMany(mappedBy = "nhanVien")
    private List<PhieuNhap> phieuNhaps;
    @OneToMany(mappedBy = "nhanVien")
    private List<PhieuHuy> phieuHuys;

    public NhanVien(int maNV, String tenNhanVien, boolean gioiTinh, String cmnd, Date date, String soDienThoai, String email, String diachi, Date date1, int maChucVu, boolean b) {
        ChucVuDAO chucVuDAO = new ChucVuDAO(ChucVu.class);
        this.maNV = maNV;
        this.tenNV = tenNhanVien;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.ngaySinh = date;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diachi;
        this.ngayThamGia = date1;
        this.chucVu = chucVuDAO.select(maChucVu);
        this.isDeleted = b;
    }


    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV=" + maNV +
                ", tenNV='" + tenNV + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", cmnd='" + cmnd + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngayThamGia=" + ngayThamGia +
                ", maChucVu=" + chucVu.getMaChucVu() +
                ", isDeleted=" + isDeleted +
                '}';
    }


}
