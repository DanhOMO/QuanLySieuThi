package service;

import Entity.ChiTietPhieuHuy;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CTPhieuHuyService extends Remote {
    boolean insert(ChiTietPhieuHuy chiTietPhieuHuy) throws RemoteException;
    boolean delete(Integer maPhieu, Integer maSP) throws RemoteException;
    boolean update(Integer maPhieu, Integer maSP, ChiTietPhieuHuy chiTietPhieuHuy) throws RemoteException;
    ChiTietPhieuHuy select(Integer maPhieu, Integer maSP) throws RemoteException;
    List<ChiTietPhieuHuy> selectAll() throws RemoteException;
    List<ChiTietPhieuHuy> selectAllById1(Integer maPhieu) throws RemoteException;
    List<ChiTietPhieuHuy> selectAllById2(Integer maSP) throws RemoteException;
}
