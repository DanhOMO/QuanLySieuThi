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
@Table(name = "LOAISANPHAM")
public class LoaiSanPham implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "MALOAI")
    private int maLoai;
    @Column(name = "TENLOAI")
    private String tenLoai;
    @Column(name = "MOTA")
    private String moTa;
    @Column(name = "ISDELETED")
    private boolean isDeleted;
    @OneToMany(mappedBy = "loaiSanPham")
    private List<SanPham> sanPhams;

    public LoaiSanPham(int i, String laptop, String laptopDeNangCao, boolean b) {
        this.maLoai = i;
        this.tenLoai = laptop;
        this.moTa = laptopDeNangCao;
        this.isDeleted = b;
    }


    @Override
    public String toString() {
        return "LoaiSanPham{" +
                "maLoai=" + maLoai +
                ", tenLoai='" + tenLoai + '\'' +
                ", moTa='" + moTa + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
