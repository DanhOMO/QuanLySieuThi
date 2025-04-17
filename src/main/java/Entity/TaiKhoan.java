package Entity;

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
@Table(name = "TAIKHOAN")

public class TaiKhoan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SOTK")
    private int soTK;
    @Column(name = "TENTK")
    private String tenTK;
    @Column(name = "MATKHAU")
    private String matKhau;
    @ManyToOne
    @JoinColumn(name = "MANV")
    private NhanVien nhanVien;

    @Column(name = "SOLANSAI")
    private int soLanSai;
    @Column(name = "NGAYTAO")
    private Timestamp ngayTao;
    @Column(name = "ISDELETED")
    private boolean isDeleted;
    @OneToMany(mappedBy = "taiKhoan")
    private List<LoginDetail> loginDetail;
    @Override
    public String toString() {
        return "TaiKhoan{" +
                "soTK=" + soTK +
                ", tenTK='" + tenTK + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", maNV=" + nhanVien.getMaNV() +
                ", soLanSai=" + soLanSai +
                ", ngayTao=" + ngayTao +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
