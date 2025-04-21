package service;

import Entity.PhieuHuy;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PhieuHuyService extends Remote {
    boolean insert(PhieuHuy phieuHuy) throws RemoteException;
    boolean delete(Integer maPhieuHuy) throws RemoteException;
    boolean update(Integer maPhieuHuy, PhieuHuy phieuHuy) throws RemoteException;
    PhieuHuy select(Integer maPhieuHuy) throws RemoteException;
    List<PhieuHuy> selectAll() throws RemoteException;
    PhieuHuy selectNewest() throws RemoteException;
    List<PhieuHuy> selectAndFilter(String maNV, String maPN, String ngayBD, String ngayKT) throws RemoteException;
}
