package service.impl;

import DAL.DataAcessObject.ChucVuDAO;
import Entity.ChucVu;
import service.ChucVuService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ChucVuServiceImpl extends UnicastRemoteObject implements ChucVuService {

    private ChucVuDAO chucVuDAO;

    public ChucVuServiceImpl(ChucVuDAO chucVuDAO) throws RemoteException {
        super();
        this.chucVuDAO = chucVuDAO;
    }

    @Override
    public boolean insert(ChucVu chucVu) throws RemoteException {
        return chucVuDAO.insert(chucVu);
    }

    @Override
    public boolean delete(Integer maChucVu) throws RemoteException {
        return chucVuDAO.delete(maChucVu);
    }

    @Override
    public boolean update(Integer maChucVu, ChucVu chucVu) throws RemoteException {
        return chucVuDAO.update(maChucVu, chucVu);
    }

    @Override
    public ChucVu select(Integer maChucVu) throws RemoteException {
        return chucVuDAO.select(maChucVu);
    }

    @Override
    public List<ChucVu> selectAll() throws RemoteException {
        return chucVuDAO.selectAll();
    }
}
