/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS.BusAccessor;

import DAL.DataAcessObject.NhaCungCapDAO;
import DAL.DataAcessObject.PhieuHuyDAO;
import Entity.ChiTietPhieuHuy;
import Entity.NhaCungCap;
import Entity.PhieuHuy;
import java.util.List;

/**
 *
 * @author huykh
 */
public class PhieuHuyBUS extends AbstractBUSAccessor<PhieuHuy, Integer, PhieuHuyDAO>{
    
    public List<PhieuHuy> getFilter(String maNV, String maPN, String ngayBD, String ngayKT) {
        return dao.selectAndFilter(maNV, maPN, ngayBD, ngayKT);
    }

    public List<PhieuHuy> getPhieuHuyInTime(String ngayBD, String ngayKT) {
        return dao.selectAndFilter("", "", ngayBD, ngayKT);
    }

    @Override
    public boolean add(PhieuHuy phieuHuy) {
        return dao.insert(phieuHuy);
    }

    @Override
    public boolean remove(Integer maPhieuHuy) {
        return dao.delete(maPhieuHuy);
    }

    @Override
    public boolean edit(Integer maPhieuHuy, PhieuHuy phieuHuy) {
        return dao.update(maPhieuHuy, phieuHuy);
    }

    @Override
    public PhieuHuy get(Integer maPhieuHuy) {
        return dao.select(maPhieuHuy);
    }
    public List<PhieuHuy> getAll(){
        return dao.selectAll();
    }

    @Override
    public PhieuHuy getNewest(){
        return dao.selectNewest();
    }
    
}
