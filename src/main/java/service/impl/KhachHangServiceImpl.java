package service.impl;

import DAL.DataAcessObject.KhachHangDAO;
import Entity.KhachHang;
import service.KhachHangService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class KhachHangServiceImpl extends UnicastRemoteObject implements KhachHangService {

    private KhachHangDAO khachHangDAO;
    public KhachHangServiceImpl(KhachHangDAO khachHangDAO) throws RemoteException {
        super();
        this.khachHangDAO = khachHangDAO;
    }

    @Override
    public boolean insert(KhachHang khachHang) throws RemoteException {
        return khachHangDAO.insert(khachHang);
    }

    @Override
    public boolean delete(Integer maKhachHang) throws RemoteException {
        return khachHangDAO.delete(maKhachHang);
    }

    @Override
    public boolean update(Integer maKhachHang, KhachHang khachHang) throws RemoteException {
        return khachHangDAO.update(maKhachHang, khachHang);
    }

    @Override
    public KhachHang select(Integer maKhachHang) throws RemoteException {
        return khachHangDAO.select(maKhachHang);
    }

    @Override
    public List<KhachHang> selectAll() throws RemoteException {
        return khachHangDAO.selectAll();
    }

    @Override
    public KhachHang selectByPhoneNumber(String sdt) throws RemoteException {
        return khachHangDAO.selectByPhoneNumber(sdt);
    }

    @Override
    public KhachHang getNewestKey() throws RemoteException {
        return khachHangDAO.getNewestKey();
    }
}
