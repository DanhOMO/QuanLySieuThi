package com.quanlysieuthi.quanlysieuthimini.datamau;

import com.quanlysieuthi.quanlysieuthimini.entity.KhuyenMai;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class KhuyenMaiDataFaker {

    public static List<KhuyenMai> generateKhuyenMaiList(int count) {
        Faker faker = new Faker();
        List<KhuyenMai> khuyenMaiList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            KhuyenMai khuyenMai = new KhuyenMai();
            khuyenMai.setMaKhuyenMai("KM" + faker.number().digits(6)); // Mã khuyến mãi ngẫu nhiên

            // Tạo ngày bắt đầu và ngày kết thúc hợp lệ
            Date ngayBatDau = faker.date().past(30, TimeUnit.DAYS); // Ngày bắt đầu trong vòng 30 ngày qua
            Date ngayKetThuc = faker.date().future(30, TimeUnit.DAYS); // Ngày kết thúc sau ngày bắt đầu, trong vòng 30 ngày tới

            khuyenMai.setNgayBatDau(ngayBatDau);
            khuyenMai.setNgayKetThuc(ngayKetThuc);

            // Điều kiện và chiết khấu
            khuyenMai.setDieuKien(faker.number().randomDouble(2, 100000, 500000)); // Điều kiện từ 100k đến 500k
            khuyenMai.setChieuKhau(faker.number().randomDouble(2, 5, 30)); // Chiết khấu từ 5% đến 30%

            khuyenMaiList.add(khuyenMai);
        }
        return khuyenMaiList;
    }

    public static void main(String[] args) {
        // Tạo danh sách khuyến mãi
        List<KhuyenMai> khuyenMaiList = generateKhuyenMaiList(10);

        khuyenMaiList.forEach(khuyenMai -> {
            System.out.println("Mã khuyến mãi: " + khuyenMai.getMaKhuyenMai());
            System.out.println("Ngày bắt đầu: " + khuyenMai.getNgayBatDau());
            System.out.println("Ngày kết thúc: " + khuyenMai.getNgayKetThuc());
            System.out.println("Điều kiện: " + khuyenMai.getDieuKien());
            System.out.println("Chiết khấu: " + khuyenMai.getChieuKhau());
            System.out.println("--------------------");
        });
    }
}
