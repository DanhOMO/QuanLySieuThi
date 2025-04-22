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
@Table(name = "NHACUNGCAP")

public class NhaCungCap implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANCC")
    private int maNCC;
    @Column(name = "TENNCC")
    private String tenNCC;
    @Column(name = "DIACHI")
    private String diaChi;
    @Column(name = "SDT")
    private String sdt;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ISDELETED")
    private boolean isDeleted;
    @OneToMany(mappedBy = "nhaCungCap")
    private List<SanPham> sanPhams;

    public NhaCungCap(int i, String a, String b, String c, String d, boolean e) {
        this.maNCC = i;
        this.tenNCC = a;
        this.diaChi = b;
        this.sdt = c;
        this.email = d;
        this.isDeleted = e;
    }

    @Override
    public String toString() {
        return "NhaCungCap{" +
                "maNCC=" + maNCC +
                ", tenNCC='" + tenNCC + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", email='" + email + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
