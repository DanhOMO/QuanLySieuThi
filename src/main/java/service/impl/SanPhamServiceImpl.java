package service.impl;

import DAL.DataAcessObject.SanPhamDAO;
import Entity.SanPham;
import service.SanPhamService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SanPhamServiceImpl extends UnicastRemoteObject implements SanPhamService {

    private SanPhamDAO sanPhamDAO;

    public SanPhamServiceImpl(SanPhamDAO sanPhamDAO) throws RemoteException {
        super();
        this.sanPhamDAO = sanPhamDAO;
    }

    @Override
    public boolean insert(SanPham sanPham) throws RemoteException {
        return sanPhamDAO.insert(sanPham);
    }

    @Override
    public boolean delete(Integer maSanPham) throws RemoteException {
        return sanPhamDAO.delete(maSanPham);
    }

    @Override
    public boolean update(Integer maSanPham, SanPham sanPham) throws RemoteException {
        return sanPhamDAO.update(maSanPham, sanPham);
    }

    @Override
    public SanPham select(Integer maSanPham) throws RemoteException {
        return sanPhamDAO.select(maSanPham);
    }

    @Override
    public List<SanPham> selectAll() throws RemoteException {
        return sanPhamDAO.selectAll();
    }

    @Override
    public SanPham selectNewest() throws RemoteException {
        return sanPhamDAO.selectNewest();
    }

    @Override
    public List<SanPham> selectByLoaiSP(int maLoai) throws RemoteException {
        return sanPhamDAO.selectByLoaiSP(maLoai);
    }

    @Override
    public List<SanPham> selectByTenSP(String tenSP) throws RemoteException {
        return sanPhamDAO.selectByTenSP(tenSP);
    }

    @Override
    public List<SanPham> selectTenHayMoTa(String findKey) throws RemoteException {
        return sanPhamDAO.selectTenHayMoTa(findKey);
    }

    @Override
    public List<SanPham> selectByNhaCungCap(String maNCC) throws RemoteException {
        return sanPhamDAO.selectByNhaCungCap(maNCC);
    }

    @Override
    public List<SanPham> selectByMoney(String minMoney, String maxMoney) throws RemoteException {
        return sanPhamDAO.selectByMoney(minMoney, maxMoney);
    }

    @Override
    public List<SanPham> selectByTenSPAndLoaiSP(int maLoai, String tenSP) throws RemoteException {
        return sanPhamDAO.selectByTenSPAndLoaiSP(maLoai, tenSP);
    }

    @Override
    public List<SanPham> selectAllSanPham() throws RemoteException {
        return sanPhamDAO.selectAllSanPham();
    }
}
