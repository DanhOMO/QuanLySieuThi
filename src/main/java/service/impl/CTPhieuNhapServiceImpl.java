package service.impl;

import DAL.DataAcessObject.CTPhieuNhapDAO;
import Entity.ChiTietPhieuNhap;
import service.CTPhieuNhapService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CTPhieuNhapServiceImpl extends UnicastRemoteObject implements CTPhieuNhapService {

    private CTPhieuNhapDAO ctPhieuNhapDAO;

    public CTPhieuNhapServiceImpl(CTPhieuNhapDAO ctPhieuNhapDAO) throws RemoteException {
        super();
        this.ctPhieuNhapDAO = ctPhieuNhapDAO;
    }

    @Override
    public boolean insert(ChiTietPhieuNhap chiTietPhieuNhap) throws RemoteException {
        return ctPhieuNhapDAO.insert(chiTietPhieuNhap);
    }

    @Override
    public boolean delete(Integer maPhieu, Integer maSP) throws RemoteException {
        return ctPhieuNhapDAO.delete(maPhieu, maSP);
    }

    @Override
    public boolean update(Integer maPhieu, Integer maSP, ChiTietPhieuNhap chiTietPhieuNhap) throws RemoteException {
        return ctPhieuNhapDAO.update(maPhieu, maSP, chiTietPhieuNhap);
    }

    @Override
    public ChiTietPhieuNhap select(Integer maPhieu, Integer maSP) throws RemoteException {
        return ctPhieuNhapDAO.select(maPhieu, maSP);
    }

    @Override
    public List<ChiTietPhieuNhap> selectAll() throws RemoteException {
        return ctPhieuNhapDAO.selectAll();
    }

    @Override
    public List<ChiTietPhieuNhap> selectAllById1(Integer maPhieu) throws RemoteException {
        return ctPhieuNhapDAO.selectAllById1(maPhieu);
    }

    @Override
    public List<ChiTietPhieuNhap> selectAllById2(Integer maSP) throws RemoteException {
        return ctPhieuNhapDAO.selectAllById2(maSP);
    }
}
