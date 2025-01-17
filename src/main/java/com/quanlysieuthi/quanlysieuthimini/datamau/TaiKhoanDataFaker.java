package com.quanlysieuthi.quanlysieuthimini.datamau;

import com.quanlysieuthi.quanlysieuthimini.entity.NhanVien;
import com.quanlysieuthi.quanlysieuthimini.entity.TaiKhoan;
import com.quanlysieuthi.quanlysieuthimini.enumClass.TrangThaiTaiKhoan;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDataFaker {

    public static List<TaiKhoan> generateTaiKhoanList(int count, List<NhanVien> nhanVienList) {
        Faker faker = new Faker();
        List<TaiKhoan> taiKhoanList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            TaiKhoan taiKhoan = new TaiKhoan();
            taiKhoan.setMaTaiKhoan("TK" + faker.number().digits(6)); // Mã tài khoản ngẫu nhiên
            taiKhoan.setTenDangNhap(faker.name().username()); // Tên đăng nhập ngẫu nhiên
            taiKhoan.setMatKhau(faker.internet().password()); // Mật khẩu ngẫu nhiên
            taiKhoan.setTrangThai(faker.options().option(TrangThaiTaiKhoan.values())); // Trạng thái tài khoản ngẫu nhiên

            // Lấy ngẫu nhiên một nhân viên từ danh sách
            NhanVien nhanVien = nhanVienList.get(faker.number().numberBetween(0, nhanVienList.size()));
            taiKhoan.setNhanVien(nhanVien);

            taiKhoanList.add(taiKhoan);
        }
        return taiKhoanList;
    }

    public static void main(String[] args) {
        // Tạo danh sách nhân viên mẫu từ NhanVienDataFaker (giả định đã có)
        List<NhanVien> nhanVienList = NhanVienDataFaker.generateNhanVienList(10); // Tạo 10 nhân viên

        // Tạo danh sách tài khoản
        List<TaiKhoan> taiKhoanList = generateTaiKhoanList(10, nhanVienList);

        taiKhoanList.forEach(taiKhoan -> {
            System.out.println("Mã tài khoản: " + taiKhoan.getMaTaiKhoan());
            System.out.println("Tên đăng nhập: " + taiKhoan.getTenDangNhap());
            System.out.println("Mật khẩu: " + taiKhoan.getMatKhau());
            System.out.println("Trạng thái: " + taiKhoan.getTrangThai());
            System.out.println("Nhân viên: " + taiKhoan.getNhanVien().getHoTen());
            System.out.println("--------------------");
        });
    }
}
