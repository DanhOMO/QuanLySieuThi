package service;

import Entity.NhanVien;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface NhanVienService extends Remote {
    boolean insert(NhanVien nhanVien) throws RemoteException;
    boolean delete(Integer maNhanVien) throws RemoteException;
    boolean update(Integer maNhanVien, NhanVien nhanVien) throws RemoteException;
    NhanVien select(Integer maNhanVien) throws RemoteException;
    List<NhanVien> selectAll() throws RemoteException;
    NhanVien selectNewest() throws RemoteException;
    int getSoLuongHoaDon(int maNhanVien) throws RemoteException;
    long getDoanhThu(int maNhanVien) throws RemoteException;
}
