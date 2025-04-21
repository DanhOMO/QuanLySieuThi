package service;

import Entity.TaiKhoan;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface TaiKhoanService extends Remote {
    boolean insert(TaiKhoan taiKhoan) throws RemoteException;
    boolean delete(Integer soTaiKhoan) throws RemoteException;
    boolean update(Integer soTaiKhoan, TaiKhoan taiKhoan) throws RemoteException;
    TaiKhoan select(Integer soTaiKhoan) throws RemoteException;
    List<TaiKhoan> selectAll() throws RemoteException;
    TaiKhoan selectByTenTK(String username) throws RemoteException;
}
