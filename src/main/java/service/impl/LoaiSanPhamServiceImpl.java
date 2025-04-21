package service.impl;

import DAL.DataAcessObject.LoaiSanPhamDAO;
import Entity.LoaiSanPham;
import service.LoaiSanPhamService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class LoaiSanPhamServiceImpl extends UnicastRemoteObject implements LoaiSanPhamService {

    private LoaiSanPhamDAO loaiSanPhamDAO;

    public LoaiSanPhamServiceImpl(LoaiSanPhamDAO loaiSanPhamDAO) throws RemoteException {
        super();
        this.loaiSanPhamDAO = loaiSanPhamDAO;
    }

    @Override
    public boolean insert(LoaiSanPham loaiSanPham) throws RemoteException {
        return loaiSanPhamDAO.insert(loaiSanPham);
    }

    @Override
    public boolean delete(Integer maLoaiSanPham) throws RemoteException {
        return loaiSanPhamDAO.delete(maLoaiSanPham);
    }

    @Override
    public boolean update(Integer maLoaiSanPham, LoaiSanPham loaiSanPham) throws RemoteException {
        return loaiSanPhamDAO.update(maLoaiSanPham, loaiSanPham);
    }

    @Override
    public LoaiSanPham select(Integer maLoaiSanPham) throws RemoteException {
        return loaiSanPhamDAO.select(maLoaiSanPham);
    }

    @Override
    public List<LoaiSanPham> selectAll() throws RemoteException {
        return loaiSanPhamDAO.selectAll();
    }
}
