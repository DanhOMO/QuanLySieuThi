package service.impl;

import DAL.DataAcessObject.CTPhieuHuyDAO;
import Entity.ChiTietPhieuHuy;
import service.CTPhieuHuyService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CTPhieuHuyServiceImpl extends UnicastRemoteObject implements CTPhieuHuyService {

    private CTPhieuHuyDAO ctPhieuHuyDAO;

    public CTPhieuHuyServiceImpl(CTPhieuHuyDAO ctPhieuHuyDAO) throws RemoteException {
        super();
        this.ctPhieuHuyDAO = ctPhieuHuyDAO;
    }

    @Override
    public boolean insert(ChiTietPhieuHuy chiTietPhieuHuy) throws RemoteException {
        return ctPhieuHuyDAO.insert(chiTietPhieuHuy);
    }

    @Override
    public boolean delete(Integer maPhieu, Integer maSP) throws RemoteException {
        return ctPhieuHuyDAO.delete(maPhieu, maSP);
    }

    @Override
    public boolean update(Integer maPhieu, Integer maSP, ChiTietPhieuHuy chiTietPhieuHuy) throws RemoteException {
        return ctPhieuHuyDAO.update(maPhieu, maSP, chiTietPhieuHuy);
    }

    @Override
    public ChiTietPhieuHuy select(Integer maPhieu, Integer maSP) throws RemoteException {
        return ctPhieuHuyDAO.select(maPhieu, maSP);
    }

    @Override
    public List<ChiTietPhieuHuy> selectAll() throws RemoteException {
        return ctPhieuHuyDAO.selectAll();
    }

    @Override
    public List<ChiTietPhieuHuy> selectAllById1(Integer maPhieu) throws RemoteException {
        return ctPhieuHuyDAO.selectAllById1(maPhieu);
    }

    @Override
    public List<ChiTietPhieuHuy> selectAllById2(Integer maSP) throws RemoteException {
        return ctPhieuHuyDAO.selectAllById2(maSP);
    }
}
