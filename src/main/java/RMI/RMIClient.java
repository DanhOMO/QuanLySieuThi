package RMI;

import Entity.*;
import GUI.SaleGroup.LoginGui.LoginFrame.LoginGui;
import com.formdev.flatlaf.FlatLightLaf;
import service.*;
import service.impl.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.List;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Context context = new InitialContext();
            ClientRegistryService clientRegistryService = (ClientRegistryService) context.lookup("rmi://localhost:9090/ClientRegistryService");
            KhachHangService khachHangService = (KhachHangService) context.lookup("rmi://localhost:9090/KhachHangService");
            ChiTietHoaDonService chiTietHoaDonService = (ChiTietHoaDonService) context.lookup("rmi://localhost:9090/ChiTietHoaDonService");
            ChucVuService chucVuService = (ChucVuService) context.lookup("rmi://localhost:9090/ChucVuService");
            CTPhieuHuyService ctPhieuHuyService = (CTPhieuHuyService) context.lookup("rmi://localhost:9090/CTPhieuHuyService");
            CTPhieuNhapService ctPhieuNhapService = (CTPhieuNhapService) context.lookup("rmi://localhost:9090/CTPhieuNhapService");
            GiamGiaSPService giamGiaSPService = (GiamGiaSPService) context.lookup("rmi://localhost:9090/GiamGiaSPService");
            HoaDonService hoaDonService = (HoaDonService) context.lookup("rmi://localhost:9090/HoaDonService");
            LoaiSanPhamService loaiSanPhamService = (LoaiSanPhamService) context.lookup("rmi://localhost:9090/LoaiSanPhamService");
            LoginDetailService loginDetailService = (LoginDetailService) context.lookup("rmi://localhost:9090/LoginDetailService");
            NhaCungCapService nhaCungCapService = (NhaCungCapService) context.lookup("rmi://localhost:9090/NhaCungCapService");
            NhanVienService nhanVienService = (NhanVienService) context.lookup("rmi://localhost:9090/NhanVienService");
            PhieuHuyService phieuHuyService = (PhieuHuyService) context.lookup("rmi://localhost:9090/PhieuHuyService");
            PhieuNhapService phieuNhapService = (PhieuNhapService) context.lookup("rmi://localhost:9090/PhieuNhapService");
            SanPhamService sanPhamService = (SanPhamService) context.lookup("rmi://localhost:9090/SanPhamService");
            TaiKhoanService taiKhoanService = (TaiKhoanService) context.lookup("rmi://localhost:9090/TaiKhoanService");
            VoucherService voucherService = (VoucherService) context.lookup("rmi://localhost:9090/VoucherService");
            clientRegistryService.registerClient("Client_A");

            KhachHang khachHang = khachHangService.select(1);
            if (khachHang != null) {
                System.out.println("KhachHang ID: " + khachHang.getMaKH());
            } else {
                System.out.println("KhachHang not found!");
            }

            ChiTietHoaDon chiTietHoaDon = chiTietHoaDonService.select(1, 1001);
            if (chiTietHoaDon != null) {
                System.out.println("ChiTietHoaDon ID: " + chiTietHoaDon.getId());
            } else {
                System.out.println("ChiTietHoaDon not found!");
            }

            ChucVu chucVu = chucVuService.select(1);
            if (chucVu != null) {
                System.out.println("ChucVu ID: " + chucVu.getMaChucVu());
            } else {
                System.out.println("ChucVu not found!");
            }

            PhieuHuy phieuHuy = phieuHuyService.select(1);
            if (phieuHuy != null) {
                System.out.println("PhieuHuy ID: " + phieuHuy.getMaPhieu());
            } else {
                System.out.println("PhieuHuy not found!");
            }

            PhieuNhap phieuNhap = phieuNhapService.select(1);
            if (phieuNhap != null) {
                System.out.println("PhieuNhap ID: " + phieuNhap.getMaPhieu());
            } else {
                System.out.println("PhieuNhap not found!");
            }

            List<SanPham> allSanPham = sanPhamService.selectAll();
            for (SanPham sp : allSanPham) {
                System.out.println("SanPham: " + sp.getTenSP());
            }

            TaiKhoan taiKhoan = taiKhoanService.select(1);
            if (taiKhoan != null) {
                System.out.println("TaiKhoan ID: " + taiKhoan.getSoTK());
            } else {
                System.out.println("TaiKhoan not found!");
            }

            Voucher voucher = voucherService.select("GIAM25K");
            if (voucher != null) {
                System.out.println("Voucher Code: " + voucher.getMaVoucher());
            } else {
                System.out.println("Voucher not found!");
            }


            List<HoaDon> allHoaDon = hoaDonService.selectAll();
            for (HoaDon hd : allHoaDon) {
                System.out.println("HoaDon ID: " + hd.getMaHD());
            }


            List<NhaCungCap> allNhaCungCap = nhaCungCapService.selectAll();
            for (NhaCungCap ncc : allNhaCungCap) {
                System.out.println("NhaCungCap: " + ncc.getTenNCC());
            }
            FlatLightLaf.setup();
            new LoginGui();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
