package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GenericSerivce<T> extends Remote {

//     T findById(ID id) throws RemoteException;
//     List<T> getAll() throws RemoteException;
//     boolean save(T t) throws RemoteException;
//     boolean update(T t) throws RemoteException;

     boolean insert(T entity) throws RemoteException;
     boolean update(int id, T entity) throws RemoteException;
     boolean delete(int id) throws RemoteException;
     T select(int id) throws RemoteException;
     List<T> selectAll() throws RemoteException;


}

