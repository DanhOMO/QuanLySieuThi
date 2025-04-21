package service;

import Entity.LoginDetail;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LoginDetailService extends Remote {
    boolean insert(LoginDetail loginDetail) throws RemoteException;
    boolean delete(Integer loginId) throws RemoteException;
    boolean update(Integer loginId, LoginDetail loginDetail) throws RemoteException;
    LoginDetail select(Integer loginId) throws RemoteException;
    List<LoginDetail> selectAll() throws RemoteException;
    LoginDetail selectByNewestSoTK(int soTK) throws RemoteException;
    LoginDetail selectByAuthKey(String authKey) throws RemoteException;
}

