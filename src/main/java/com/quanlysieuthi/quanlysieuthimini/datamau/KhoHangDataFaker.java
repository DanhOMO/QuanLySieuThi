package com.quanlysieuthi.quanlysieuthimini.datamau;

import com.quanlysieuthi.quanlysieuthimini.entity.KhoHang;
import com.quanlysieuthi.quanlysieuthimini.entity.SanPham;
import net.datafaker.Faker;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class KhoHangDataFaker {

    public static List<KhoHang> generateKhoHangList(int count) {
        Faker faker = new Faker();
        List<KhoHang> khoHangList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            KhoHang khoHang = new KhoHang();
            khoHang.setMaKhoHang("KH" + faker.number().digits(4)); // Mã kho hàng với tiền tố KH và 4 chữ số
            khoHang.setGiaNhap(BigDecimal.valueOf(faker.number().randomDouble(2, 50, 500))); // Giá nhập ngẫu nhiên từ 50 đến 500
            khoHang.setGiaBan(BigDecimal.valueOf(faker.number().randomDouble(2, 100, 1000))); // Giá bán ngẫu nhiên từ 100 đến 1000
            khoHang.setSoLuong(faker.number().numberBetween(1, 1000)); // Số lượng kho hàng ngẫu nhiên từ 1 đến 1000

            // Thêm SanPham mẫu (cần có đối tượng này)
            SanPham sanPham = new SanPham();
            sanPham.setMaSanPham("SP" + faker.number().digits(4)); // Mã sản phẩm ngẫu nhiên
            sanPham.setTenSanPham(faker.commerce().productName()); // Tên sản phẩm ngẫu nhiên
            khoHang.setSanPham(sanPham);

            khoHangList.add(khoHang);
        }

        return khoHangList;
    }

    public static void main(String[] args) {
        List<KhoHang> khoHangList = generateKhoHangList(5); // Tạo danh sách 5 kho hàng mẫu

        khoHangList.forEach(khoHang -> {
            System.out.println("Mã kho hàng: " + khoHang.getMaKhoHang());
            System.out.println("Giá nhập: " + khoHang.getGiaNhap());
            System.out.println("Giá bán: " + khoHang.getGiaBan());
            System.out.println("Số lượng: " + khoHang.getSoLuong());
            System.out.println("Mã sản phẩm: " + khoHang.getSanPham().getMaSanPham());
            System.out.println("Tên sản phẩm: " + khoHang.getSanPham().getTenSanPham());
            System.out.println("--------------------");
        });
    }
}
