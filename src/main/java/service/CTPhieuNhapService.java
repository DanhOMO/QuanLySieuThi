package service;

import Entity.ChiTietPhieuNhap;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CTPhieuNhapService extends Remote {
    boolean insert(ChiTietPhieuNhap chiTietPhieuNhap) throws RemoteException;
    boolean delete(Integer maPhieu, Integer maSP) throws RemoteException;
    boolean update(Integer maPhieu, Integer maSP, ChiTietPhieuNhap chiTietPhieuNhap) throws RemoteException;
    ChiTietPhieuNhap select(Integer maPhieu, Integer maSP) throws RemoteException;
    List<ChiTietPhieuNhap> selectAll() throws RemoteException;
    List<ChiTietPhieuNhap> selectAllById1(Integer maPhieu) throws RemoteException;
    List<ChiTietPhieuNhap> selectAllById2(Integer maSP) throws RemoteException;
}
