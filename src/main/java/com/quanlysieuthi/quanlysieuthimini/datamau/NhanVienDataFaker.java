package com.quanlysieuthi.quanlysieuthimini.entity;

import com.quanlysieuthi.quanlysieuthimini.enumClass.ChucVu;
import com.quanlysieuthi.quanlysieuthimini.enumClass.GioiTinh;
import com.quanlysieuthi.quanlysieuthimini.enumClass.TrangThaiNhanVien;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class NhanVienDataFaker {

    public static List<NhanVien> generateNhanVienList(int count) {
        Faker faker = new Faker();
        List<NhanVien> nhanVienList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNhanVien("NV" + faker.number().digits(5));
            nhanVien.setHoTen(faker.name().fullName());
            nhanVien.setSdt(faker.phoneNumber().cellPhone());
            nhanVien.setDiaChi(faker.address().fullAddress());
            nhanVien.setCccd(faker.number().digits(12));
            nhanVien.setNgaySinh(faker.timeAndDate().birthday());
            nhanVien.setGioiTinh(faker.options().option(GioiTinh.values()));
            nhanVien.setChucVu(faker.options().option(ChucVu.values()));
            nhanVien.setTrangThai(faker.options().option(TrangThaiNhanVien.values()));

            nhanVienList.add(nhanVien);
        }
        return nhanVienList;
    }

    public static void main(String[] args) {
        List<NhanVien> nhanVienList = generateNhanVienList(10); // Tạo 10 nhân viên mẫu
        nhanVienList.forEach(nhanVien -> {
            System.out.println("Mã NV: " + nhanVien.getMaNhanVien());
            System.out.println("Họ tên: " + nhanVien.getHoTen());
            System.out.println("SĐT: " + nhanVien.getSdt());
            System.out.println("Địa chỉ: " + nhanVien.getDiaChi());
            System.out.println("CCCD: " + nhanVien.getCccd());
            System.out.println("Ngày sinh: " + nhanVien.getNgaySinh());
            System.out.println("Giới tính: " + nhanVien.getGioiTinh());
            System.out.println("Chức vụ: " + nhanVien.getChucVu());
            System.out.println("Trạng thái: " + nhanVien.getTrangThai());
            System.out.println("--------------------");
        });
    }
}
