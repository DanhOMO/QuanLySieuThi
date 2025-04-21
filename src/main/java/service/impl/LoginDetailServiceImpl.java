package service.impl;

import DAL.DataAcessObject.LoginDetailDAO;
import Entity.LoginDetail;
import service.LoginDetailService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class LoginDetailServiceImpl extends UnicastRemoteObject implements LoginDetailService {

    private LoginDetailDAO loginDetailDAO;

    public LoginDetailServiceImpl(LoginDetailDAO loginDetailDAO) throws RemoteException {
        super();
        this.loginDetailDAO = loginDetailDAO;
    }

    @Override
    public boolean insert(LoginDetail loginDetail) throws RemoteException {
        return loginDetailDAO.insert(loginDetail);
    }

    @Override
    public boolean delete(Integer loginId) throws RemoteException {
        return loginDetailDAO.delete(loginId);
    }

    @Override
    public boolean update(Integer loginId, LoginDetail loginDetail) throws RemoteException {
        return loginDetailDAO.update(loginId, loginDetail);
    }

    @Override
    public LoginDetail select(Integer loginId) throws RemoteException {
        return loginDetailDAO.select(loginId);
    }

    @Override
    public List<LoginDetail> selectAll() throws RemoteException {
        return loginDetailDAO.selectAll();
    }

    @Override
    public LoginDetail selectByNewestSoTK(int soTK) throws RemoteException {
        return loginDetailDAO.selectByNewestSoTK(soTK);
    }

    @Override
    public LoginDetail selectByAuthKey(String authKey) throws RemoteException {
        return loginDetailDAO.selectByAuthKey(authKey);
    }
}
