package service.impl;

import DAL.DataAcessObject.TaiKhoanDAO;
import Entity.TaiKhoan;
import service.TaiKhoanService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class TaiKhoanServiceImpl extends UnicastRemoteObject implements TaiKhoanService {

    private TaiKhoanDAO taiKhoanDAO;

    public TaiKhoanServiceImpl(TaiKhoanDAO taiKhoanDAO) throws RemoteException {
        super();
        this.taiKhoanDAO = taiKhoanDAO;
    }

    @Override
    public boolean insert(TaiKhoan taiKhoan) throws RemoteException {
        return taiKhoanDAO.insert(taiKhoan);
    }

    @Override
    public boolean delete(Integer soTaiKhoan) throws RemoteException {
        return taiKhoanDAO.delete(soTaiKhoan);
    }

    @Override
    public boolean update(Integer soTaiKhoan, TaiKhoan taiKhoan) throws RemoteException {
        return taiKhoanDAO.update(soTaiKhoan, taiKhoan);
    }

    @Override
    public TaiKhoan select(Integer soTaiKhoan) throws RemoteException {
        return taiKhoanDAO.select(soTaiKhoan);
    }

    @Override
    public List<TaiKhoan> selectAll() throws RemoteException {
        return taiKhoanDAO.selectAll();
    }

    @Override
    public TaiKhoan selectByTenTK(String username) throws RemoteException {
        return taiKhoanDAO.selectByTenTK(username);
    }
}
