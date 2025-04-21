package service;

import Entity.HoaDon;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface HoaDonService extends Remote {
    boolean insert(HoaDon hoaDon) throws RemoteException;
    boolean delete(Integer maHoaDon) throws RemoteException;
    boolean update(Integer maHoaDon, HoaDon hoaDon) throws RemoteException;
    HoaDon select(Integer maHoaDon) throws RemoteException;
    List<HoaDon> selectAll() throws RemoteException;
    HoaDon selectNewestBill() throws RemoteException;
    List<HoaDon> selectHoaDonTrongKhoang(String startDay, String endDay) throws RemoteException;
}

