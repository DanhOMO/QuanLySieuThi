package Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@MappedSuperclass
@NoArgsConstructor
public abstract class ChiTietPhieu implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ChiTietPhieuId chiTietPhieuId;

    @Column(name = "SOLUONG")
    protected int soLuong;

    public ChiTietPhieu(int soLuong) {
        this.soLuong = soLuong;
    }
}
