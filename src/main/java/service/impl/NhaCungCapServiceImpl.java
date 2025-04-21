package service.impl;

import DAL.DataAcessObject.NhaCungCapDAO;
import Entity.NhaCungCap;
import service.NhaCungCapService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class NhaCungCapServiceImpl extends UnicastRemoteObject implements NhaCungCapService {

    private NhaCungCapDAO nhaCungCapDAO;

    public NhaCungCapServiceImpl(NhaCungCapDAO nhaCungCapDAO) throws RemoteException {
        super();
        this.nhaCungCapDAO = nhaCungCapDAO;
    }

    @Override
    public boolean insert(NhaCungCap nhaCungCap) throws RemoteException {
        return nhaCungCapDAO.insert(nhaCungCap);
    }

    @Override
    public boolean delete(Integer maNhaCungCap) throws RemoteException {
        return nhaCungCapDAO.delete(maNhaCungCap);
    }

    @Override
    public boolean update(Integer maNhaCungCap, NhaCungCap nhaCungCap) throws RemoteException {
        return nhaCungCapDAO.update(maNhaCungCap, nhaCungCap);
    }

    @Override
    public NhaCungCap select(Integer maNhaCungCap) throws RemoteException {
        return nhaCungCapDAO.select(maNhaCungCap);
    }

    @Override
    public List<NhaCungCap> selectAll() throws RemoteException {
        return nhaCungCapDAO.selectAll();
    }

    @Override
    public NhaCungCap selectNewest() throws RemoteException {
        return nhaCungCapDAO.selectNewest();
    }
}
