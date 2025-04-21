package service;

import Entity.NhaCungCap;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface NhaCungCapService extends Remote {
    boolean insert(NhaCungCap nhaCungCap) throws RemoteException;
    boolean delete(Integer maNhaCungCap) throws RemoteException;
    boolean update(Integer maNhaCungCap, NhaCungCap nhaCungCap) throws RemoteException;
    NhaCungCap select(Integer maNhaCungCap) throws RemoteException;
    List<NhaCungCap> selectAll() throws RemoteException;
    NhaCungCap selectNewest() throws RemoteException;
}
