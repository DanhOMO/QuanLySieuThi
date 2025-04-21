package service.impl;

import DAL.DataAcessObject.ChiTietHoaDonDAO;
import Entity.ChiTietHoaDon;
import service.ChiTietHoaDonService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ChiTietHoaDonImpl extends UnicastRemoteObject implements ChiTietHoaDonService {
    private ChiTietHoaDonDAO chiTietHoaDonDAO;

    public ChiTietHoaDonImpl(ChiTietHoaDonDAO chiTietHoaDonDAO) throws RemoteException {
        super();
        this.chiTietHoaDonDAO = chiTietHoaDonDAO;
    }

    @Override
    public boolean insert(ChiTietHoaDon chiTietHoaDon) throws RemoteException {
        return chiTietHoaDonDAO.insert(chiTietHoaDon);
    }

    @Override
    public boolean update(Integer maHoaDon, Integer maSanPham, ChiTietHoaDon chiTietHoaDon) throws RemoteException {
        return chiTietHoaDonDAO.update(maHoaDon, maSanPham, chiTietHoaDon);
    }

    @Override
    public boolean delete(Integer maHoaDon, Integer maSanPham) throws RemoteException {
        return chiTietHoaDonDAO.delete(maHoaDon, maSanPham);
    }

    @Override
    public ChiTietHoaDon select(Integer maHoaDon, Integer maSanPham) throws RemoteException {
        return chiTietHoaDonDAO.select(maHoaDon, maSanPham);
    }

    @Override
    public List<ChiTietHoaDon> selectAll() throws RemoteException {
        return chiTietHoaDonDAO.selectAll();
    }

    @Override
    public List<ChiTietHoaDon> selectAllById1(Integer maHoaDon) throws RemoteException {
        return chiTietHoaDonDAO.selectAllById1(maHoaDon);
    }

    @Override
    public List<ChiTietHoaDon> selectAllById2(Integer maSanPham) throws RemoteException {
        return chiTietHoaDonDAO.selectAllById2(maSanPham);
    }
}
