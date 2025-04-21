package service;

import Entity.LoaiSanPham;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LoaiSanPhamService extends Remote {
    boolean insert(LoaiSanPham loaiSanPham) throws RemoteException;
    boolean delete(Integer maLoaiSanPham) throws RemoteException;
    boolean update(Integer maLoaiSanPham, LoaiSanPham loaiSanPham) throws RemoteException;
    LoaiSanPham select(Integer maLoaiSanPham) throws RemoteException;
    List<LoaiSanPham> selectAll() throws RemoteException;
}
