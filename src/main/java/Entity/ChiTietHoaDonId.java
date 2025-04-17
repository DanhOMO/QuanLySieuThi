package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChiTietHoaDonId implements Serializable {
    private int maHD;
    private int maSP;
}
