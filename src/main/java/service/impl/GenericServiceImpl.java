package service.impl;

import DAL.DataAcessObject.GenericDao;
import service.GenericSerivce;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class GenericServiceImpl<T> extends UnicastRemoteObject implements GenericSerivce<T> {

    protected GenericDao<T> genericDAO;
    public GenericServiceImpl(GenericDao<T> genericDAO) throws RemoteException {
       super();
        this.genericDAO = genericDAO;
    }


    @Override
    public boolean insert(T entity) throws RemoteException {
        return genericDAO.save(entity);
    }

    @Override
    public boolean update(int id, T entity) throws RemoteException {
        return genericDAO.update(entity);
    }

    @Override
    public boolean delete(int id) throws RemoteException {
        return genericDAO.delete(id);
    }

    @Override
    public T select(int id) throws RemoteException {
        return genericDAO.findById(id);
    }

    @Override
    public List<T> selectAll() throws RemoteException {
        return genericDAO.findAll();
    }
}
