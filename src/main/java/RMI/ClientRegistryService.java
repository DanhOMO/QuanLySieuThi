package RMI;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientRegistryService extends Remote {
    void registerClient(String clientName) throws RemoteException;
}