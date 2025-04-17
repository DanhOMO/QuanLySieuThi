package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "PHIEUHUY")
public class PhieuHuy extends Phieu {

    @OneToMany(mappedBy = "phieu")
    private List<ChiTietPhieuHuy> chiTietPhieuHuys;
    public PhieuHuy(int i, Timestamp timestamp, NhanVien select, boolean b) {
        super(i, timestamp, b, select, b);
    }

    public PhieuHuy() {}

    @Override
    public String toString() {
        return "PhieuHuy{" +
                "maPhieu=" + getMaPhieu() +
                ", ngayLap=" + getNgayLap() +
                ", maNV=" + getNhanVien().getMaNV() +
                ", isDeleted=" + isDeleted() +
                '}';
    }
}
