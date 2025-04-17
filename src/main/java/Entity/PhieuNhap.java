package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "PHIEUNHAP")
public class PhieuNhap extends Phieu {

    @OneToMany(mappedBy = "phieu")
    private List<ChiTietPhieuNhap> chiTietPhieuNhaps;

    public PhieuNhap(int i, Timestamp timestamp, int maNhanVien, boolean b) {
        super(i, timestamp, maNhanVien, b);
    }

    public PhieuNhap() {}

    @Override
    public String toString() {
        return "PhieuNhap{" +
                "maPhieu=" + getMaPhieu() +
                ", ngayLap=" + getNgayLap() +
                ", maNV=" + getNhanVien().getMaNV() +
                ", isDeleted=" + isDeleted() +
                "}";
    }
}
