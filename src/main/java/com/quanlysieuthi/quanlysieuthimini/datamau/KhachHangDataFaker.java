package com.quanlysieuthi.quanlysieuthimini.datamau;

import com.quanlysieuthi.quanlysieuthimini.entity.KhachHang;
import com.quanlysieuthi.quanlysieuthimini.enumClass.GioiTinh;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KhachHangDataFaker {
    public static List<KhachHang> generateFakeKhachHang(int numberOfCustomers) {
        Faker faker = new Faker();
        Random random = new Random();
        List<KhachHang> khachHangList = new ArrayList<>();

        for (int i = 0; i < numberOfCustomers; i++) {
            KhachHang khachHang = new KhachHang();
            khachHang.setMaKhachHang("KH" + (i + 1));
            khachHang.setHoTen(faker.name().fullName());
            khachHang.setSdt(generateFakePhoneNumber());  // Sử dụng phương thức tạo số điện thoại giả
            khachHang.setDiaChi(faker.address().fullAddress());
            khachHang.setCccd(String.valueOf(100000000 + random.nextInt(900000000))); // Random CCCD
            khachHang.setGioiTinh(random.nextBoolean() ? GioiTinh.NAM : GioiTinh.NU);
            khachHang.setNgaySinh(LocalDate.now().minusYears(18 + random.nextInt(42))); // 18-60 tuổi
            khachHang.setDiemTichLuy(random.nextInt(1000)); // Điểm tích lũy từ 0-999
            khachHangList.add(khachHang);
        }

        return khachHangList;
    }

    // Phương thức tạo số điện thoại giả
    public static String generateFakePhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder("0");
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(10));  // Thêm số ngẫu nhiên vào
        }
        return phoneNumber.toString();
    }

    public static void main(String[] args) {
        List<KhachHang> fakeCustomers = generateFakeKhachHang(10); // Tạo 10 khách hàng giả
        fakeCustomers.forEach(System.out::println);
    }
}
