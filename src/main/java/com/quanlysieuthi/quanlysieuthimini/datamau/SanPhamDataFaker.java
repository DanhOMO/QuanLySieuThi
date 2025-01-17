package com.quanlysieuthi.quanlysieuthimini.datamau;

import com.quanlysieuthi.quanlysieuthimini.entity.LoaiSanPham;
import com.quanlysieuthi.quanlysieuthimini.entity.NhaCungCap;
import com.quanlysieuthi.quanlysieuthimini.entity.SanPham;
import com.quanlysieuthi.quanlysieuthimini.enumClass.TrangThaiSanPham;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanPhamDataFaker {

    public static List<SanPham> generateSanPhamList(int count, List<LoaiSanPham> loaiSanPhamList) {
        Faker faker = new Faker();
        List<SanPham> sanPhamList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            SanPham sanPham = new SanPham();
            sanPham.setMaSanPham("SP" + UUID.randomUUID().toString().substring(0, 8)); // Mã sản phẩm ngẫu nhiên
            sanPham.setTenSanPham(faker.commerce().productName()); // Tên sản phẩm ngẫu nhiên
            sanPham.setNgaySanXuat(LocalDate.now().minusDays(faker.number().numberBetween(1, 1000))); // Ngày sản xuất ngẫu nhiên
            sanPham.setHanSuDung(LocalDate.now().plusDays(faker.number().numberBetween(30, 365))); // Hạn sử dụng ngẫu nhiên
            sanPham.setTrangThai(faker.options().option(TrangThaiSanPham.values())); // Trạng thái ngẫu nhiên
            sanPham.setMoTa(faker.lorem().sentence()); // Mô tả sản phẩm ngẫu nhiên
            sanPham.setThue(faker.number().randomDouble(2, 1, 10)); // Thuế từ 1% đến 10%

            // Lấy ngẫu nhiên một LoaiSanPham từ danh sách được truyền vào
            LoaiSanPham loaiSanPham = loaiSanPhamList.get(faker.number().numberBetween(0, loaiSanPhamList.size()));
            sanPham.setLoaiSanPham(loaiSanPham);

            // Tạo NhaCungCap mẫu
            NhaCungCap nhaCungCap = new NhaCungCap();
            nhaCungCap.setMaNhaCungCap("NCC" + faker.number().digits(4));
            nhaCungCap.setTenNhaCungCap(faker.company().name());
            nhaCungCap.setSoDienThoai(faker.phoneNumber().cellPhone());
            nhaCungCap.setEmail(faker.internet().emailAddress());
            nhaCungCap.setDiaChi(faker.address().fullAddress());
            sanPham.setNhaCungCap(nhaCungCap);

            sanPhamList.add(sanPham);
        }
        return sanPhamList;
    }

    public static void main(String[] args) {
        // Tạo danh sách LoaiSanPham mẫu từ LoaiSanPhamDataFaker
        List<LoaiSanPham> loaiSanPhamList = LoaiSanPhamDataFaker.generateLoaiSanPhamList(5); // Tạo 5 loại sản phẩm

        // Tạo danh sách SanPham mẫu, sử dụng danh sách LoaiSanPham đã tạo
        List<SanPham> sanPhamList = generateSanPhamList(10, loaiSanPhamList); // Tạo 10 sản phẩm

        sanPhamList.forEach(sanPham -> {
            System.out.println("Mã sản phẩm: " + sanPham.getMaSanPham());
            System.out.println("Tên sản phẩm: " + sanPham.getTenSanPham());
            System.out.println("Ngày sản xuất: " + sanPham.getNgaySanXuat());
            System.out.println("Hạn sử dụng: " + sanPham.getHanSuDung());
            System.out.println("Trạng thái: " + sanPham.getTrangThai());
            System.out.println("Mô tả: " + sanPham.getMoTa());
            System.out.println("Thuế: " + sanPham.getThue());
            System.out.println("Loại sản phẩm: " + sanPham.getLoaiSanPham().getTenLoai());
            System.out.println("Nhà cung cấp: " + sanPham.getNhaCungCap().getTenNhaCungCap());
            System.out.println("--------------------");
        });
    }
}
