/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS.BusAccessor;

import DAL.DataAcessObject.PhieuNhapDAO;
import Entity.ChiTietPhieuNhap;
import Entity.PhieuHuy;
import Entity.PhieuNhap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author huykh
 */
public class PhieuNhapBUS extends AbstractBUSAccessor<PhieuNhap, Integer, PhieuNhapDAO>{


    public List<PhieuNhap> getPhieuNhapInTime(String ngayBD, String ngayKT) {
        return dao.selectAndFilter("", "", ngayBD, ngayKT);
    }

    @Override
    public boolean add(PhieuNhap phieuNhap) {
        return dao.insert(phieuNhap);
    }
    @Override
    public boolean remove(Integer maPhieuNhap) {
       return dao.delete(maPhieuNhap);
    }

    @Override
    public boolean edit(Integer maPhieuNhap, PhieuNhap phieuNhap) {
        return dao.update(maPhieuNhap, phieuNhap);
    }

    @Override
    public PhieuNhap get(Integer maPhieuNhap) {
        return dao.select(maPhieuNhap);
    }

    @Override
    public List<PhieuNhap> getAll(){
        return dao.selectAll();
    }

    @Override
    public PhieuNhap getNewest(){
        return dao.selectNewest();
    }

    public List<PhieuNhap> getFilter(String maNV, String maPN, String ngayBD, String ngayKT) {
        return dao.selectAndFilter(maNV, maPN, ngayBD, ngayKT);
    }

    
}
