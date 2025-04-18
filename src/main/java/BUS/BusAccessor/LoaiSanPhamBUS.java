/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS.BusAccessor;

import DAL.DataAcessObject.LoaiSanPhamDAO;
import Entity.LoaiSanPham;

/**
 *
 * @author huykh
 */
public class LoaiSanPhamBUS extends AbstractBUSAccessor<LoaiSanPham, Integer, LoaiSanPhamDAO>{
    public LoaiSanPhamBUS() {
        this.setDao(new LoaiSanPhamDAO(LoaiSanPham.class));
    }
}
