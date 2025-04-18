/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS.BusAccessor;

import DAL.DataAcessObject.NhaCungCapDAO;
import Entity.NhaCungCap;
import java.util.List;


public class NhaCungCapBUS implements IBussAccess<NhaCungCap, Integer>{
    private final NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO(NhaCungCap.class);


    @Override
    public NhaCungCap get(Integer maNCC) {
        return nhaCungCapDAO.select(maNCC);
    }

    @Override
    public List<NhaCungCap> getAll() {
        return nhaCungCapDAO.selectAll();
    }

    @Override
    public boolean add(NhaCungCap nhaCungCap) {
        return nhaCungCapDAO.insert(nhaCungCap);
    }

    @Override
    public boolean edit(Integer maNhaCungCap, NhaCungCap ncc) {
       return nhaCungCapDAO.update(maNhaCungCap, ncc);
    }

    @Override
    public boolean remove(Integer maNhaCungCap) {
        return nhaCungCapDAO.delete(maNhaCungCap);
    }

    @Override
    public NhaCungCap getNewest() {
        return nhaCungCapDAO.selectNewest();
    }
    
}
