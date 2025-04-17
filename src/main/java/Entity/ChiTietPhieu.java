package Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@NoArgsConstructor
public abstract class ChiTietPhieu {

    @EmbeddedId
    protected ChiTietPhieuId chiTietPhieuId;

    @Column(name = "SOLUONG")
    protected int soLuong;

    public ChiTietPhieu(int soLuong) {
        this.soLuong = soLuong;
    }
}
