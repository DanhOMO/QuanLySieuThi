package com.quanlysieuthi.quanlysieuthimini.datamau;

import com.quanlysieuthi.quanlysieuthimini.entity.NhaCungCap;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDataFaker {

    public static List<NhaCungCap> generateNhaCungCapList(int count) {
        Faker faker = new Faker();
        List<NhaCungCap> nhaCungCapList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            NhaCungCap nhaCungCap = new NhaCungCap();
            nhaCungCap.setMaNhaCungCap("NCC" + faker.number().digits(4)); // Mã nhà cung cấp với tiền tố NCC và 4 chữ số
            nhaCungCap.setTenNhaCungCap(faker.company().name()); // Tên công ty ngẫu nhiên
            nhaCungCap.setSoDienThoai(faker.phoneNumber().cellPhone()); // Số điện thoại di động ngẫu nhiên
            nhaCungCap.setEmail(faker.internet().emailAddress()); // Email ngẫu nhiên
            nhaCungCap.setDiaChi(faker.address().fullAddress()); // Địa chỉ ngẫu nhiên

            nhaCungCapList.add(nhaCungCap);
        }

        return nhaCungCapList;
    }

    public static void main(String[] args) {
        List<NhaCungCap> nhaCungCapList = generateNhaCungCapList(5); // Tạo danh sách 5 nhà cung cấp mẫu

        nhaCungCapList.forEach(nhaCungCap -> {
            System.out.println("Mã nhà cung cấp: " + nhaCungCap.getMaNhaCungCap());
            System.out.println("Tên nhà cung cấp: " + nhaCungCap.getTenNhaCungCap());
            System.out.println("Số điện thoại: " + nhaCungCap.getSoDienThoai());
            System.out.println("Email: " + nhaCungCap.getEmail());
            System.out.println("Địa chỉ: " + nhaCungCap.getDiaChi());
            System.out.println("--------------------");
        });
    }
}
