package service;


import Entity.ChucVu;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChucVuService extends Remote {
    boolean insert(ChucVu chucVu) throws RemoteException;
    boolean delete(Integer maChucVu) throws RemoteException;
    boolean update(Integer maChucVu, ChucVu chucVu) throws RemoteException;
    ChucVu select(Integer maChucVu) throws RemoteException;
    List<ChucVu> selectAll() throws RemoteException;
}
