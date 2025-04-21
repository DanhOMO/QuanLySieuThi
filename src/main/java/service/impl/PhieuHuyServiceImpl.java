package service.impl;

import DAL.DataAcessObject.PhieuHuyDAO;
import Entity.PhieuHuy;
import service.PhieuHuyService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class PhieuHuyServiceImpl extends UnicastRemoteObject implements PhieuHuyService {

    private PhieuHuyDAO phieuHuyDAO;

    public PhieuHuyServiceImpl(PhieuHuyDAO phieuHuyDAO) throws RemoteException {
        super();
        this.phieuHuyDAO = phieuHuyDAO;
    }

    @Override
    public boolean insert(PhieuHuy phieuHuy) throws RemoteException {
        return phieuHuyDAO.insert(phieuHuy);
    }

    @Override
    public boolean delete(Integer maPhieuHuy) throws RemoteException {
        return phieuHuyDAO.delete(maPhieuHuy);
    }

    @Override
    public boolean update(Integer maPhieuHuy, PhieuHuy phieuHuy) throws RemoteException {
        return phieuHuyDAO.update(maPhieuHuy, phieuHuy);
    }

    @Override
    public PhieuHuy select(Integer maPhieuHuy) throws RemoteException {
        return phieuHuyDAO.select(maPhieuHuy);
    }

    @Override
    public List<PhieuHuy> selectAll() throws RemoteException {
        return phieuHuyDAO.selectAll();
    }

    @Override
    public PhieuHuy selectNewest() throws RemoteException {
        return phieuHuyDAO.selectNewest();
    }

    @Override
    public List<PhieuHuy> selectAndFilter(String maNV, String maPN, String ngayBD, String ngayKT) throws RemoteException {
        return phieuHuyDAO.selectAndFilter(maNV, maPN, ngayBD, ngayKT);
    }
}
