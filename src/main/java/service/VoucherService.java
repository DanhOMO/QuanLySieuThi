package service;

import Entity.Voucher;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface VoucherService extends Remote {
    boolean insert(Voucher voucher) throws RemoteException;
    boolean delete(String maVoucher) throws RemoteException;
    boolean update(String maVoucher, Voucher voucher) throws RemoteException;
    Voucher select(String maVoucher) throws RemoteException;
    List<Voucher> selectAll() throws RemoteException;
}
