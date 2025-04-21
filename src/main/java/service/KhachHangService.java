package service;

import Entity.KhachHang;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface KhachHangService extends Remote {

    boolean insert(KhachHang khachHang) throws RemoteException;
    boolean delete(Integer maKhachHang) throws RemoteException;
    boolean update(Integer maKhachHang, KhachHang khachHang) throws RemoteException;
    KhachHang select(Integer maKhachHang) throws RemoteException;
    List<KhachHang> selectAll() throws RemoteException;
    KhachHang selectByPhoneNumber(String sdt) throws RemoteException;
    KhachHang getNewestKey() throws RemoteException;
}
