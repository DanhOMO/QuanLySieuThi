package service;

import Entity.PhieuNhap;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PhieuNhapService extends Remote {
    boolean insert(PhieuNhap phieuNhap) throws RemoteException;
    boolean delete(Integer maPhieuNhap) throws RemoteException;
    boolean update(Integer maPhieuNhap, PhieuNhap phieuNhap) throws RemoteException;
    PhieuNhap select(Integer maPhieuNhap) throws RemoteException;
    List<PhieuNhap> selectAll() throws RemoteException;
    PhieuNhap selectNewest() throws RemoteException;
    List<PhieuNhap> selectAndFilter(String maNV, String maPN, String ngayBD, String ngayKT) throws RemoteException;
}
