
import BUS.AccountServices.LoginAction;
import DAL.DataAcessObject.HoaDonDAO;
import DAL.DataAcessObject.KhachHangDAO;
import DAL.DataAcessObject.LoaiSanPhamDAO;
import DAL.DataAcessObject.SanPhamDAO;
import Entity.KhachHang;
import Entity.SanPham;
import GUI.SaleGroup.LoginGui.LoginFrame.LoginGui;
import Utils.JPAUtils;
import com.formdev.flatlaf.FlatLightLaf;
import jakarta.persistence.EntityManager;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {
//        EntityManager em = JPAUtils.getEntityManager();
        FlatLightLaf.setup();
        new LoginGui();
//        SanPhamDAO sanPhamDAO = new SanPhamDAO(SanPham.class);
//        sanPhamDAO.selectAll().forEach(System.out::println);
//        HoaDonDAO hoaDonDAO = new HoaDonDAO();
//        hoaDonDAO.selectAll().forEach(System.out::println);
    }
}
