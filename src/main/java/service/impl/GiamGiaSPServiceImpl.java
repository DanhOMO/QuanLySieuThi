package service.impl;

import DAL.DataAcessObject.GiamGiaSPDAO;
import Entity.GiamGiaSP;
import service.GiamGiaSPService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class GiamGiaSPServiceImpl extends UnicastRemoteObject implements GiamGiaSPService {

    private GiamGiaSPDAO giamGiaSPDAO;

    public GiamGiaSPServiceImpl(GiamGiaSPDAO giamGiaSPDAO) throws RemoteException {
        super();
        this.giamGiaSPDAO = giamGiaSPDAO;
    }

    @Override
    public boolean insert(GiamGiaSP giamGiaSP) throws RemoteException {
        return giamGiaSPDAO.insert(giamGiaSP);
    }

    @Override
    public boolean delete(Integer soPhieu) throws RemoteException {
        return giamGiaSPDAO.delete(soPhieu);
    }

    @Override
    public boolean update(Integer soPhieu, GiamGiaSP giamGiaSP) throws RemoteException {
        return giamGiaSPDAO.update(soPhieu, giamGiaSP);
    }

    @Override
    public GiamGiaSP select(Integer soPhieu) throws RemoteException {
        return giamGiaSPDAO.select(soPhieu);
    }

    @Override
    public List<GiamGiaSP> selectAll() throws RemoteException {
        return giamGiaSPDAO.selectAll();
    }

    @Override
    public GiamGiaSP selectByMaSP(Integer maSP) throws RemoteException {
        return giamGiaSPDAO.selectByMaSP(maSP);
    }
}
