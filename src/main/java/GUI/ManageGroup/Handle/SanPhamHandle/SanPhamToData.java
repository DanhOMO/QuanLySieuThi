
package GUI.ManageGroup.Handle.SanPhamHandle;

import DAL.DataAcessObject.LoaiSanPhamDAO;
import DAL.DataAcessObject.NhaCungCapDAO;
import DAL.DataAcessObject.SanPhamDAO;
import Entity.LoaiSanPham;
import Entity.NhaCungCap;
import Entity.SanPham;


public class SanPhamToData {
    SanPhamDAO spDao = new SanPhamDAO(SanPham.class);
    LoaiSanPhamDAO lspDao = new LoaiSanPhamDAO(LoaiSanPham.class);
    NhaCungCapDAO nccDao = new NhaCungCapDAO(NhaCungCap.class);
    public boolean AddSanPham (String Gia,String Ten,int nhaCungCap,int Loai,String Mota,String url)
            {
                SanPham sp =new SanPham();
                Long gia =Long.valueOf(Gia);
                sp.setGiaTien(gia);
                int loai = Integer.valueOf(Loai);
                sp.setLoaiSanPham(lspDao.select(loai));
                int NhaCC = Integer.valueOf(nhaCungCap);
                sp.setNhaCungCap(nccDao.select(NhaCC));
                sp.setTenSP(Ten);
                sp.setMoTa(Mota);
                sp.setHinhAnh(url);
                return spDao.insert(sp);
            }
}
