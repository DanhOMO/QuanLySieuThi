package service.impl;

import DAL.DataAcessObject.NhanVienDAO;
import Entity.NhanVien;
import service.NhanVienService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class NhanVienServiceImpl extends UnicastRemoteObject implements NhanVienService {

    private NhanVienDAO nhanVienDAO;

    public NhanVienServiceImpl(NhanVienDAO nhanVienDAO) throws RemoteException {
        super();
        this.nhanVienDAO = nhanVienDAO;
    }

    @Override
    public boolean insert(NhanVien nhanVien) throws RemoteException {
        return nhanVienDAO.insert(nhanVien);
    }

    @Override
    public boolean delete(Integer maNhanVien) throws RemoteException {
        return nhanVienDAO.delete(maNhanVien);
    }

    @Override
    public boolean update(Integer maNhanVien, NhanVien nhanVien) throws RemoteException {
        return nhanVienDAO.update(maNhanVien, nhanVien);
    }

    @Override
    public NhanVien select(Integer maNhanVien) throws RemoteException {
        return nhanVienDAO.select(maNhanVien);
    }

    @Override
    public List<NhanVien> selectAll() throws RemoteException {
        return nhanVienDAO.selectAll();
    }

    @Override
    public NhanVien selectNewest() throws RemoteException {
        return nhanVienDAO.selectNewest();
    }

    @Override
    public int getSoLuongHoaDon(int maNhanVien) throws RemoteException {
        return nhanVienDAO.getSoLuongHoaDon(maNhanVien);
    }

    @Override
    public long getDoanhThu(int maNhanVien) throws RemoteException {
        return nhanVienDAO.getDoanhThu(maNhanVien);
    }
}
