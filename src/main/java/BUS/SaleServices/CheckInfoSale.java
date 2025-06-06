package BUS.SaleServices;


import DAL.DataAcessObject.KhachHangDAO;
import DAL.DataAcessObject.SanPhamDAO;
import DAL.DataAcessObject.VoucherDAO;
import Entity.KhachHang;
import Entity.SanPham;
import Entity.Voucher;


public class CheckInfoSale {
    private final SanPhamDAO spDAO = new SanPhamDAO(SanPham.class);
    private final KhachHangDAO khDAO = new KhachHangDAO(KhachHang.class);
    private final VoucherDAO voucherDAO = new VoucherDAO(Voucher.class);
//    private KhachHang khachHang;
    
    
    //hàm này được gọi khi sự kiện click chuột vào panel MenuItem được thực hiện
    public boolean hasProduct(int maSP){
        return spDAO.select(maSP).getSoLuong() != 0;
    }
    
    public boolean isProductExsist(int maSP){
        return spDAO.select(maSP) != null;
    }
    
    //Hàm này được gọi để xem số lượng có đápứng đủ nhu cầu khách hàng không
    public boolean isEnoughAmountProduct(int maSP, int sl){     
        return spDAO.select(maSP).getSoLuong() >= sl;
    }
    
    //hàm này được gọi khi nhấn button thêm để kiểm tra mã khách hàng
    public boolean isPassengerExist(String sdt){ 
        return khDAO.selectByPhoneNumber(sdt) != null;
    }
    
    public boolean hasVoucher(String maVoucher){
        return voucherDAO.select(maVoucher) != null;
    }
    
    //Hàm này được gọi sau khi kiểm tra khách hàng đã tồn tại
    public boolean canUsePoint(String sdt){
        if(isPassengerExist(sdt)){
            return khDAO.selectByPhoneNumber(sdt).getDiemThuong() >= 1000;
        }
        return false;
    }
        
   
//    public static void main(String[] agrv){
//        CheckInfoSale c = new CheckInfoSale();
//        System.out.println(c.isEnoughAmountProduct(1, 2));
//    }
}
