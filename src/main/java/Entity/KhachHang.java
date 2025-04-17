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
