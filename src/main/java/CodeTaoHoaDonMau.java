
import BUS.BusAccessor.CTHoaDonBUS;
import BUS.BusAccessor.HoaDonBUS;
import BUS.BusAccessor.KhachHangBUS;
import BUS.BusAccessor.NhanVienBUS;
import BUS.BusAccessor.SanPhamBUS;
import BUS.BusAccessor.VoucherBUS;
import DAL.DataAcessObject.GiamGiaSPDAO;
import DAL.DataAcessObject.HoaDonDAO;
import Entity.ChiTietHoaDon;
import Entity.ChucVu;
import Entity.GiamGiaSP;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.SanPham;
import Entity.Voucher;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author huykh
 */
public class CodeTaoHoaDonMau {
    public static void main(String[] args){
        HoaDonBUS hdBus = new HoaDonBUS();
        CTHoaDonBUS cthdBus = new CTHoaDonBUS();
        SanPhamBUS spbus = new SanPhamBUS();
        KhachHangBUS khBus = new KhachHangBUS();
        NhanVienBUS nvBus = new NhanVienBUS();
        VoucherBUS voucherBus = new VoucherBUS();
        GiamGiaSPDAO giamGiaSP = new GiamGiaSPDAO(GiamGiaSP.class);
        
        List<KhachHang> listKH = khBus.getAll();
        List<NhanVien> listNV = nvBus.getAll();
        List<Voucher> listVoucher = voucherBus.getAll();
        List<SanPham> listSP;
        
        // Tao 50 hoa don mau
        for (int i =0;i<50;i++){
            int soChiTietHoaDon = (int) (Math.random()*15+2);
//            HoaDon hd = new HoaDon();
            Long tongTien = 0L;
            listSP = spbus.getAll();
            List<ChiTietHoaDon> listCTHD = new ArrayList<>();
            for (int j=0;j<soChiTietHoaDon;j++){
                int randomSL =  random(1,10);
                int indexSP = random(0, listSP.size()-1);
                SanPham sp = listSP.get(indexSP);
                listSP.remove(sp);
                GiamGiaSP giamGia = giamGiaSP.selectByMaSP(sp.getMaSP());
                Long giaTien = sp.getGiaTien();
                if (giamGia != null){
                    giaTien = giaTien - (giaTien*giamGia.getPtGiam()/100);
                }
                ChiTietHoaDon cthd = new ChiTietHoaDon(sp.getMaSP(), 0, randomSL, giaTien);
                tongTien += giaTien*randomSL;
                listCTHD.add(cthd);
            }
            boolean isHasVoucher = ((int) (Math.random()*2+1))==2;
            int voucherIndex = random(0, listVoucher.size()-1);
            Voucher voucher = null;
            Long tienGiam = 0L;
            if (isHasVoucher){
                voucher = listVoucher.get(voucherIndex);
                if (tongTien>=voucher.getGiaTriToiThieu()){
                    tienGiam = voucher.getPtGiam()*tongTien ;
                    if (tienGiam > voucher.getKmToiDa())
                        tienGiam = voucher.getKmToiDa();
                }
            }
            NhanVien nv = listNV.get(random(0, listNV.size()-1));
            while (nv.getChucVu().getMaChucVu() != ChucVu.NHANVIENBANHANG){
                nv = listNV.get(random(0, listNV.size()-1));
            }
            int maKH = listKH.get(random(0,listKH.size()-1)).getMaKH();
            Random generator = new Random();
            Long value = (long) (generator.nextDouble() * ((1653708571665L - 1650000000000L) + 1)) + 1650000000000L;

            //             HoaDon(int maHD, Timestamp ngayHD, String hinhThuc, long tongTien, long tienGiam, int maKH, int maNV, int soKM, boolean isDeleted)
            HoaDon hd = new HoaDon(0, new Timestamp(value), "Tien mat", tongTien, tienGiam, maKH, nv.getMaNV(), String.valueOf(voucher == null ? 1:voucher.getMaVoucher()), false);
            hdBus.add(hd);
            int maHD = hdBus.getNewest().getMaHD();
            thayDoiMaHoaDon(listCTHD, maHD);
            for (ChiTietHoaDon ct:listCTHD){
                cthdBus.add(ct);
            }
        }
    }
    
    public static void thayDoiMaHoaDon(List<ChiTietHoaDon> list, int maHD){
        HoaDonDAO hdDao = new HoaDonDAO(HoaDon.class);
        for (ChiTietHoaDon i : list){
           i.setHoaDon(hdDao.select(maHD));
        }
    }
    
    public static int random(int min, int max){
        return (int) ((Math.random()) * ((max - min) + 1) + min);
        
    }
        
}
