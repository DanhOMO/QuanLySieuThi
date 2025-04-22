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
@Table(name = "VOUCHER")
public class Voucher implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "SOVOUCHER")
    private int soVoucher;
    @Column(name = "MAVOUCHER")
    private String maVoucher;
    @Column(name = "MOTA")
    private String moTa;
    @Column(name = "NGAYBD")
    private Timestamp ngayBD;
    @Column(name = "NGAYKT")
    private Timestamp ngayKT;
    @Column(name = "GIATRITOITHIEU")
    private long giaTriToiThieu;
    @Column(name = "KMTOIDA")
    private long kmToiDa;
    @Column(name = "PTGIAM")
    private int ptGiam;
    @Column(name = "SOLUOTSD")
    private int soLuotSD;
    @Column(name = "ISDELETED")
    private boolean isDeleted;
    @OneToMany(mappedBy = "soVoucher")
    private List<HoaDon> hoaDons;

    public Voucher(int i, String giamgia, String mota, int i1, Timestamp timestamp, Timestamp timestamp1, int i2, int i3, int i4, int i5, int i6, boolean b) {
        this.soVoucher = i;
        this.maVoucher = giamgia;
        this.moTa = mota;
        this.ngayBD = timestamp;
        this.ngayKT = timestamp1;
        this.giaTriToiThieu = i2;
        this.kmToiDa = i3;
        this.ptGiam = i4;
        this.soLuotSD = i5;
        this.isDeleted = b;
    }

    @Override
    public String toString() {
        return "MaKhuyenMai{" +
                "soKM=" + soVoucher +
                ", maKM='" + maVoucher + '\'' +
                ", moTa='" + moTa + '\'' +
                ", ngayDB=" + ngayBD +
                ", ngayKT=" + ngayKT +
                ", giaTriToiThieu=" + giaTriToiThieu +
                ", kmToiDa=" + kmToiDa +
                ", ptGiam=" + ptGiam +
                ", soLuotSD=" + soLuotSD +
                ", isDeleted=" + isDeleted +
                '}';
    }


}
