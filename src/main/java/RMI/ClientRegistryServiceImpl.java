package RMI;


import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ClientRegistryServiceImpl extends UnicastRemoteObject implements ClientRegistryService {
    private List<String> clients;

    public ClientRegistryServiceImpl() throws Exception {
        super();
        clients = new ArrayList<>();
    }

    @Override
    public synchronized void registerClient(String clientName) {
        clients.add(clientName);
        System.out.println("Client connected: " + clientName);
        System.out.println("Current clients: " + clients);
    }
}