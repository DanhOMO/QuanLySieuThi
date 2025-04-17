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
@Table(name = "CHUCVU")
public class ChucVu implements Serializable {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "MACHUCVU")
    private int maChucVu;
    @Column(name = "TENCHUCVU")
    private String tenChucVu;
    @Column(name = "MOTA")
    private String moTa;
    @Column(name = "ISDELETED")
    private boolean isDeleted;
    public static final int NHANVIENBANHANG = 1;
    public static final int NHANVIENQUANLY = 2;
    @OneToMany(mappedBy = "chucVu")
    private List<NhanVien> nhanViens;
    @Override
    public String toString() {
        return "ChucVu{" +
                "maChucVu=" + maChucVu +
                ", tenChucVu='" + tenChucVu + '\'' +
                ", moTa='" + moTa + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
