package service.impl;

import DAL.DataAcessObject.VoucherDAO;
import Entity.Voucher;
import service.VoucherService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class VoucherServiceImpl extends UnicastRemoteObject implements VoucherService {

    private VoucherDAO voucherDAO;

    public VoucherServiceImpl(VoucherDAO voucherDAO) throws RemoteException {
        super();
        this.voucherDAO = voucherDAO;
    }

    @Override
    public boolean insert(Voucher voucher) throws RemoteException {
        return voucherDAO.insert(voucher);
    }

    @Override
    public boolean delete(String maVoucher) throws RemoteException {
        return voucherDAO.delete(maVoucher);
    }

    @Override
    public boolean update(String maVoucher, Voucher voucher) throws RemoteException {
        return voucherDAO.update(maVoucher, voucher);
    }

    @Override
    public Voucher select(String maVoucher) throws RemoteException {
        return voucherDAO.select(maVoucher);
    }

    @Override
    public List<Voucher> selectAll() throws RemoteException {
        return voucherDAO.selectAll();
    }
}
