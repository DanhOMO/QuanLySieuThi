package service;

import Entity.ChiTietHoaDon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChiTietHoaDonService extends Remote {
    boolean insert(ChiTietHoaDon chiTietHoaDon) throws RemoteException;
    boolean update(Integer maHoaDon, Integer maSanPham, ChiTietHoaDon chiTietHoaDon) throws RemoteException;
    boolean delete(Integer maHoaDon, Integer maSanPham) throws RemoteException;
    ChiTietHoaDon select(Integer maHoaDon, Integer maSanPham) throws RemoteException;
    List<ChiTietHoaDon> selectAll() throws RemoteException;
    List<ChiTietHoaDon> selectAllById1(Integer maHoaDon) throws RemoteException;
    List<ChiTietHoaDon> selectAllById2(Integer maSanPham) throws RemoteException;
}
