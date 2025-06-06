package DAL.DataAcessObject;

import Entity.*;

import java.sql.Timestamp;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
//        testLoaiSanPham();
//        testNhaCungCap();
//        testSanPham();
//        testGiamGiaSP();
//        SanPhamDAO sp = new SanPhamDAO();
//        List<SanPham> list = sp.selectByTenSP("");
//        for (SanPham mysp:list){
//            System.out.println(mysp);
//        }
        PhieuNhapDAO nhapDAO = new PhieuNhapDAO(PhieuNhap.class);
//        List<PhieuNhap> list = nhapDAO.selectAndFilter("2", "", "2022/05/16", "2022/05/18");
//        for (PhieuNhap nhap:list){
//            System.out.println(nhap);
//        }
        System.out.println(nhapDAO.selectNewest());
    }

    public static void testHoaDon(){
        HoaDonDAO hoaDonDAO = new HoaDonDAO(HoaDon.class);
//        HoaDon hd = new HoaDon(1,new Timestamp(System.currentTimeMillis()),"Tien mat",1000,1,1,1,1,false);
//        System.out.println(hd);
//
//        if (hoaDonDAO.insert(hd)){
//            System.out.println("Insert success");
//        };
//
//        hd.setTongTien(333333);
//        if (hoaDonDAO.update(2,hd)){
//            System.out.println("Update success");
//        } else {
//            System.out.println("Update fail");
//        }
//
//        if (hoaDonDAO.delete(2)){
//            System.out.println("Delete success");
//        } else {
//            System.out.println("Delete fail");
//        }

        List<HoaDon> list = hoaDonDAO.selectAll();
        for (HoaDon hoaDon : list) {
            System.out.println(hoaDon);
        }
    }

    public static void testMaKhuyenMai(){
        VoucherDAO maKhuyenMaiDAO = new VoucherDAO(Voucher.class);
        Voucher mkm = new Voucher(
                1,"GIAMGIA","MOTA",2,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),
                10000,0,5000,10,200,false);
//        System.out.println(mkm);
//        MaKhuyenMai mkm1 = maKhuyenMaiDAO.select("GIAMGIA");
//        System.out.println(mkm1);
//        if (maKhuyenMaiDAO.insert(mkm)){
//            System.out.println("Insert success");
//        }
//
//        mkm.setNgayKT(Timestamp.valueOf("2023-01-01 00:00:00"));
//        if (maKhuyenMaiDAO.update("GIAMGIA",mkm)){
//            System.out.println("Update success");
//        }
//
//        if (maKhuyenMaiDAO.delete("GIAMGIA")){
//            System.out.println("Delete success");
//        }
//
//        List<MaKhuyenMai> list = maKhuyenMaiDAO.selectAll();
//        for (MaKhuyenMai maKhuyenMai : list) {
//            System.out.println(maKhuyenMai);
//        }
//

    }

//    public static void testSanPham(){
//        SanPham sp = new SanPham(0,"Sua ong tho","Sua ong tho tiet trung vinamlik 100% sua bo","D:/img/image.png",36000,1,1,1,false);
//        SanPhamDAO sanPhamDAO = new SanPhamDAO();
//        if (sanPhamDAO.insert(sp))
//            System.out.println("Insert success");
//        else
//            System.out.println("Insert fail");
//
//        sp.setGiaTien(360033120);
//        if (sanPhamDAO.update(1,sp))
//            System.out.println("Update success");
//        else
//            System.out.println("Update fail");
//
////        if (sanPhamDAO.delete(1))
////            System.out.println("Delete success");
////        else
////            System.out.println("Delete fail");
//
//        List<SanPham> list = sanPhamDAO.selectAll();
//        for (SanPham sanPham : list) {
//            System.out.println(sanPham);
//        }
//
//    }

    public static void testLoaiSanPham(){
        LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO(LoaiSanPham.class);
        LoaiSanPham lsp = new LoaiSanPham(1,"Laptop","Laptop de nang cao",false);
        loaiSanPhamDAO.insert(lsp);
//        System.out.println(lsp);
//
//        if (loaiSanPhamDAO.insert(lsp)){
//            System.out.println("Insert success");
//        };
//
//        if (loaiSanPhamDAO.update(1,lsp)){
//            System.out.println("Update success");
//        } else {
//            System.out.println("Update fail");
//        }
//
//        if (loaiSanPhamDAO.delete(1)){
//            System.out.println("Delete success");
//        } else {
//            System.out.println("Delete fail");
//        }

        List<LoaiSanPham> list = loaiSanPhamDAO.selectAll();
        for (LoaiSanPham loaiSanPham : list) {
            System.out.println(loaiSanPham);
        }
    }

    public static void testNhaCungCap(){
        NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO(NhaCungCap.class);
        NhaCungCap ncc = new NhaCungCap(1,"Duy","Ho Chi Minh","123","supply@gmail.com",false);
        System.out.println(ncc);

        if (nhaCungCapDAO.insert(ncc)){
            System.out.println("Insert success");
        }

        if (nhaCungCapDAO.update(1,ncc)){
            System.out.println("Update success");
        } else {
            System.out.println("Update fail");
        }

//        if (nhaCungCapDAO.delete(1)){
//            System.out.println("Delete success");
//        } else {
//            System.out.println("Delete fail");
//        }

        List<NhaCungCap> list = nhaCungCapDAO.selectAll();
        for (NhaCungCap nhaCungCap : list) {
            System.out.println(nhaCungCap);
        }
    }


}
