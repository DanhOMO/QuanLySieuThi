package Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "GIAMGIASP")
public class GiamGiaSP implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "SOPHIEU")
    private int soPhieu;
    @Column(name = "NGAYBD")
    private Timestamp ngayBD;
    @Column(name = "NGAYKT")
    private Timestamp ngayKT;
    @Column(name = "PTGIAM")
    private int ptGiam;
    @ManyToOne
    @JoinColumn(name = "MASP")
    private SanPham sanPham;
    @Column(name = "ISDELETED")
    private boolean isDeleted;

    public String toString(){
        return "GiamGiaSP {" +
                "soPhieu = " + soPhieu +
                ", ngayBD = " + ngayBD +
                ", ngayKT = " + ngayKT +
                ", ptGiam = " + ptGiam +
                ", maSP = " + sanPham.getMaSP() +
                ", isDeleted = " + isDeleted +
                "}";
    }
}
