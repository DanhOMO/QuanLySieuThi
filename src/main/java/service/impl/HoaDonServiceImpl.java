package service.impl;

import DAL.DataAcessObject.HoaDonDAO;
import Entity.HoaDon;
import service.HoaDonService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class HoaDonServiceImpl extends UnicastRemoteObject implements HoaDonService {

    private HoaDonDAO hoaDonDAO;

    public HoaDonServiceImpl(HoaDonDAO hoaDonDAO) throws RemoteException {
        super();
        this.hoaDonDAO = hoaDonDAO;
    }

    @Override
    public boolean insert(HoaDon hoaDon) throws RemoteException {
        return hoaDonDAO.insert(hoaDon);
    }

    @Override
    public boolean delete(Integer maHoaDon) throws RemoteException {
        return hoaDonDAO.delete(maHoaDon);
    }

    @Override
    public boolean update(Integer maHoaDon, HoaDon hoaDon) throws RemoteException {
        return hoaDonDAO.update(maHoaDon, hoaDon);
    }

    @Override
    public HoaDon select(Integer maHoaDon) throws RemoteException {
        return hoaDonDAO.select(maHoaDon);
    }

    @Override
    public List<HoaDon> selectAll() throws RemoteException {
        return hoaDonDAO.selectAll();
    }

    @Override
    public HoaDon selectNewestBill() throws RemoteException {
        return hoaDonDAO.selectNewestBill();
    }

    @Override
    public List<HoaDon> selectHoaDonTrongKhoang(String startDay, String endDay) throws RemoteException {
        return hoaDonDAO.selectHoaDonTrongKhoang(startDay, endDay);
    }
}
