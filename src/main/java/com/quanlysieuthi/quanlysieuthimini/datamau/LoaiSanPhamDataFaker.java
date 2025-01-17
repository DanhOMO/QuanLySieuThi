package com.quanlysieuthi.quanlysieuthimini.datamau;

import com.quanlysieuthi.quanlysieuthimini.entity.LoaiSanPham;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class LoaiSanPhamDataFaker {

    public static List<LoaiSanPham> generateLoaiSanPhamList(int count) {
        Faker faker = new Faker();
        List<LoaiSanPham> loaiSanPhamList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            LoaiSanPham loaiSanPham = new LoaiSanPham();
            loaiSanPham.setMaLoai("LSP" + faker.number().digits(4)); // Mã loại sản phẩm có tiền tố LSP và 4 chữ số
            loaiSanPham.setTenLoai(faker.commerce().department()); // Tên loại sản phẩm là một danh mục ngẫu nhiên
            loaiSanPhamList.add(loaiSanPham);
        }

        return loaiSanPhamList;
    }

    public static void main(String[] args) {
        List<LoaiSanPham> loaiSanPhamList = generateLoaiSanPhamList(5); // Tạo danh sách 5 loại sản phẩm mẫu

        loaiSanPhamList.forEach(loaiSanPham -> {
            System.out.println("Mã loại sản phẩm: " + loaiSanPham.getMaLoai());
            System.out.println("Tên loại sản phẩm: " + loaiSanPham.getTenLoai());
            System.out.println("--------------------");
        });
    }
}
