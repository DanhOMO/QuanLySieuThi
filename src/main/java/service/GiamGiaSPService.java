package service;

import Entity.GiamGiaSP;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GiamGiaSPService extends Remote {
    boolean insert(GiamGiaSP giamGiaSP) throws RemoteException;
    boolean delete(Integer soPhieu) throws RemoteException;
    boolean update(Integer soPhieu, GiamGiaSP giamGiaSP) throws RemoteException;
    GiamGiaSP select(Integer soPhieu) throws RemoteException;
    List<GiamGiaSP> selectAll() throws RemoteException;
    GiamGiaSP selectByMaSP(Integer maSP) throws RemoteException;
}
