package Entity;

import DAL.DataAcessObject.NhanVienDAO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass // <- thay vì @Entity
public abstract class Phieu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAPHIEU")
    protected int maPhieu;

    @Column(name = "NGAYLAP",length = 50)
    protected Timestamp ngayLap;

    @ManyToOne
    @JoinColumn(name = "MANV")
    private NhanVien nhanVien;

    @Column(name = "ISDELETED")
    protected boolean isDeleted;

    public Phieu(int maPhieu, Timestamp ngayLap, boolean isDeleted, NhanVien nhanVien, boolean b) {
        this.maPhieu = maPhieu;
        this.ngayLap = ngayLap;
        this.isDeleted = isDeleted;
        this.nhanVien = nhanVien;
    }

    public Phieu(int i, Timestamp timestamp, int maNhanVien, boolean b) {
        NhanVienDAO nhanVienDAO = new NhanVienDAO(NhanVien.class);
        this.maPhieu = i;
        this.ngayLap = timestamp;
        this.isDeleted = b;
        this.nhanVien = nhanVienDAO.select(maNhanVien);
    }
}
