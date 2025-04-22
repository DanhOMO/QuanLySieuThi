package Entity;

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
@Table(name = "KHACHHANG")
public class KhachHang implements Serializable

{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "MAKH")
    private int maKH;
    @Column(name = "TENKH")
    private String tenKH;
    @Column(name = "GIOITINH")
    private boolean gioiTinh;
    @Column(name = "SODIENTHOAI")
    private String soDienThoai;
    @Column(name = "DIACHI")
    private String diaChi;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DIEMTHUONG")
    private long diemThuong;
    @Column(name = "ISDELETED")
    private boolean isDeleted;
    @OneToMany(mappedBy = "khachHang")
    private List<HoaDon> hoaDons;

    public KhachHang(String nguyenVanA, String number, String haNoi, String date, String nam, int i, int i1, int i2, int i3, int i4, int i5, int i6) {
        this.tenKH = nguyenVanA;
        this.soDienThoai = number;
        this.diaChi = haNoi;
        this.email = date;
        this.diemThuong = i;
        this.gioiTinh = true;
        this.isDeleted = false;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKH=" + maKH +
                ", tenKH='" + tenKH + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", email='" + email + '\'' +
                ", diemThuong=" + diemThuong +
                ", isDeleted=" + isDeleted +
                '}';
    }

   
}
