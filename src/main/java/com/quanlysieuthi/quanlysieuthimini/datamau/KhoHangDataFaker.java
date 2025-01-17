package com.quanlysieuthi.quanlysieuthimini.datamau;

import com.quanlysieuthi.quanlysieuthimini.entity.KhoHang;
import com.quanlysieuthi.quanlysieuthimini.entity.LoaiSanPham;
import com.quanlysieuthi.quanlysieuthimini.entity.SanPham;
import net.datafaker.Faker;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KhoHangDataFaker {

    public static List<KhoHang> generateKhoHangList(List<SanPham> sanPhamList) {
        Faker faker = new Faker();
        Random random = new Random();
        List<KhoHang> khoHangList = new ArrayList<>();

        for (SanPham sanPham : sanPhamList) {
            KhoHang khoHang = new KhoHang();
            khoHang.setMaKhoHang("KH" + faker.number().digits(6)); // Mã kho hàng ngẫu nhiên
            khoHang.setGiaNhap(BigDecimal.valueOf(faker.number().randomDouble(2, 10000, 50000))); // Giá nhập từ 10k đến 50k
            khoHang.setGiaBan(BigDecimal.valueOf(faker.number().randomDouble(2, 15000, 100000))); // Giá bán từ 15k đến 100k
            khoHang.setSoLuong(random.nextInt(500) + 1); // Số lượng ngẫu nhiên từ 1 đến 500
            khoHang.setSanPham(sanPham); // Gán sản phẩm đã có vào kho hàng
            khoHangList.add(khoHang);
        }

        return khoHangList;
    }

    public static void main(String[] args) {
        // Tạo danh sách LoaiSanPham mẫu từ LoaiSanPhamDataFaker
        List<LoaiSanPham> loaiSanPhamList = LoaiSanPhamDataFaker.generateLoaiSanPhamList(5); // Tạo 5 loại sản phẩm

        // Tạo danh sách SanPham mẫu từ SanPhamDataFaker
        List<SanPham> sanPhamList = SanPhamDataFaker.generateSanPhamList(10, loaiSanPhamList); // Tạo 10 sản phẩm

        // Tạo danh sách KhoHang mẫu, sử dụng danh sách sản phẩm đã tạo
        List<KhoHang> khoHangList = generateKhoHangList(sanPhamList);

        khoHangList.forEach(khoHang -> {
            System.out.println("Mã kho hàng: " + khoHang.getMaKhoHang());
            System.out.println("Tên sản phẩm: " + khoHang.getSanPham().getTenSanPham());
            System.out.println("Giá nhập: " + khoHang.getGiaNhap());
            System.out.println("Giá bán: " + khoHang.getGiaBan());
            System.out.println("Số lượng: " + khoHang.getSoLuong());
            System.out.println("--------------------");
        });
    }
}
