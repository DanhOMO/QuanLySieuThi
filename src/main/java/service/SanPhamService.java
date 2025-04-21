package service;

import Entity.SanPham;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface SanPhamService extends Remote {
    boolean insert(SanPham sanPham) throws RemoteException;
    boolean delete(Integer maSanPham) throws RemoteException;
    boolean update(Integer maSanPham, SanPham sanPham) throws RemoteException;
    SanPham select(Integer maSanPham) throws RemoteException;
    List<SanPham> selectAll() throws RemoteException;
    SanPham selectNewest() throws RemoteException;
    List<SanPham> selectByLoaiSP(int maLoai) throws RemoteException;
    List<SanPham> selectByTenSP(String tenSP) throws RemoteException;
    List<SanPham> selectTenHayMoTa(String findKey) throws RemoteException;
    List<SanPham> selectByNhaCungCap(String maNCC) throws RemoteException;
    List<SanPham> selectByMoney(String minMoney, String maxMoney) throws RemoteException;
    List<SanPham> selectByTenSPAndLoaiSP(int maLoai, String tenSP) throws RemoteException;
    List<SanPham> selectAllSanPham() throws RemoteException;
}
