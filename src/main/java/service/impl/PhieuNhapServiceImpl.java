package service.impl;

import DAL.DataAcessObject.PhieuNhapDAO;
import Entity.PhieuNhap;
import service.PhieuNhapService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class PhieuNhapServiceImpl extends UnicastRemoteObject implements PhieuNhapService {

    private PhieuNhapDAO phieuNhapDAO;

    public PhieuNhapServiceImpl(PhieuNhapDAO phieuNhapDAO) throws RemoteException {
        super();
        this.phieuNhapDAO = phieuNhapDAO;
    }

    @Override
    public boolean insert(PhieuNhap phieuNhap) throws RemoteException {
        return phieuNhapDAO.insert(phieuNhap);
    }

    @Override
    public boolean delete(Integer maPhieuNhap) throws RemoteException {
        return phieuNhapDAO.delete(maPhieuNhap);
    }

    @Override
    public boolean update(Integer maPhieuNhap, PhieuNhap phieuNhap) throws RemoteException {
        return phieuNhapDAO.update(maPhieuNhap, phieuNhap);
    }

    @Override
    public PhieuNhap select(Integer maPhieuNhap) throws RemoteException {
        return phieuNhapDAO.select(maPhieuNhap);
    }

    @Override
    public List<PhieuNhap> selectAll() throws RemoteException {
        return phieuNhapDAO.selectAll();
    }

    @Override
    public PhieuNhap selectNewest() throws RemoteException {
        return phieuNhapDAO.selectNewest();
    }

    @Override
    public List<PhieuNhap> selectAndFilter(String maNV, String maPN, String ngayBD, String ngayKT) throws RemoteException {
        return phieuNhapDAO.selectAndFilter(maNV, maPN, ngayBD, ngayKT);
    }
}
