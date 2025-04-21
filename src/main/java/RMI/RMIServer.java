package RMI;

import DAL.DataAcessObject.*;
import DAL.DataAcessObject.ChucVuDAO;
import DAL.DataAcessObject.KhachHangDAO;
import Entity.*;
import service.*;
import service.KhachHangService;
import service.impl.*;
import service.impl.KhachHangServiceImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) throws  Exception {
        Context context = new InitialContext();

        LocateRegistry.createRegistry(9090);

        // Create and bind your remote objects here

        KhachHangDAO khachHangDAO = new KhachHangDAO(KhachHang.class);
        KhachHangService khachHangService = new KhachHangServiceImpl(khachHangDAO);
        context.bind("rmi://localhost:9090/KhachHangService", khachHangService);  // Địa chỉ URL

        ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO(ChiTietHoaDon.class);
        ChiTietHoaDonService chiTietHoaDonService = new ChiTietHoaDonImpl(chiTietHoaDonDAO);
        context.bind("rmi://localhost:9090/ChiTietHoaDonService", chiTietHoaDonService);

        ChucVuDAO chucVuDAO = new ChucVuDAO(ChucVu.class);
        ChucVuService chucVuService = new ChucVuServiceImpl(chucVuDAO);
        context.bind("rmi://localhost:9090/ChucVuService", chucVuService);

        CTPhieuHuyDAO ctPhieuHuyDAO = new CTPhieuHuyDAO(ChiTietPhieuHuy.class);
        CTPhieuHuyService ctPhieuHuyService = new CTPhieuHuyServiceImpl(ctPhieuHuyDAO);
        context.bind("rmi://localhost:9090/CTPhieuHuyService", ctPhieuHuyService);

        CTPhieuNhapDAO ctPhieuNhapDAO = new CTPhieuNhapDAO(ChiTietPhieuNhap.class);
        CTPhieuNhapService ctPhieuNhapService = new CTPhieuNhapServiceImpl(ctPhieuNhapDAO);
        context.bind("rmi://localhost:9090/CTPhieuNhapService", ctPhieuNhapService);

        GiamGiaSPDAO giamGiaSPDAO = new GiamGiaSPDAO(GiamGiaSP.class);
        GiamGiaSPService giamGiaSPService = new GiamGiaSPServiceImpl(giamGiaSPDAO);
        context.bind("rmi://localhost:9090/GiamGiaSPService", giamGiaSPService);


        HoaDonDAO hoaDonDAO = new HoaDonDAO(HoaDon.class);
        HoaDonService hoaDonService = new HoaDonServiceImpl(hoaDonDAO);
        context.bind("rmi://localhost:9090/HoaDonService", hoaDonService);

        LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO(LoaiSanPham.class);
        LoaiSanPhamService loaiSanPhamService = new LoaiSanPhamServiceImpl(loaiSanPhamDAO);
        context.bind("rmi://localhost:9090/LoaiSanPhamService", loaiSanPhamService);

        LoginDetailDAO loginDetailDAO = new LoginDetailDAO(LoginDetail.class);
        LoginDetailService loginDetailService = new LoginDetailServiceImpl(loginDetailDAO);
        context.bind("rmi://localhost:9090/LoginDetailService", loginDetailService);

        NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO(NhaCungCap.class);
        NhaCungCapService nhaCungCapService = new NhaCungCapServiceImpl(nhaCungCapDAO);
        context.bind("rmi://localhost:9090/NhaCungCapService", nhaCungCapService);

        NhanVienDAO nhanVienDAO = new NhanVienDAO(NhanVien.class);
        NhanVienService nhanVienService = new NhanVienServiceImpl(nhanVienDAO);
        context.bind("rmi://localhost:9090/NhanVienService", nhanVienService);

        PhieuHuyDAO phieuHuyDAO = new PhieuHuyDAO(PhieuHuy.class);
        PhieuHuyService phieuHuyService = new PhieuHuyServiceImpl(phieuHuyDAO);
        context.bind("rmi://localhost:9090/PhieuHuyService", phieuHuyService);

        PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO(PhieuNhap.class);
        PhieuNhapService phieuNhapService = new PhieuNhapServiceImpl(phieuNhapDAO);
        context.bind("rmi://localhost:9090/PhieuNhapService", phieuNhapService);

        SanPhamDAO sanPhamDAO = new SanPhamDAO(SanPham.class);
        SanPhamService sanPhamService = new SanPhamServiceImpl(sanPhamDAO);
        context.bind("rmi://localhost:9090/SanPhamService", sanPhamService);

        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO(TaiKhoan.class);
        TaiKhoanService taiKhoanService = new TaiKhoanServiceImpl(taiKhoanDAO);
        context.bind("rmi://localhost:9090/TaiKhoanService", taiKhoanService);

        VoucherDAO voucherDAO = new VoucherDAO(Voucher.class);
        VoucherService voucherService = new VoucherServiceImpl(voucherDAO);
        context.bind("rmi://localhost:9090/VoucherService", voucherService);





//        context.bind("rmi://localhost:9090/yourServiceName", yourRemoteObject);
        System.out.println("RMI Server is running...");



    }
}
