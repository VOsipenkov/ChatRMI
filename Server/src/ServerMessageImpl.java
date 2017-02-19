import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 21cmPC on 19.02.2017.
 */
public class ServerMessageImpl extends UnicastRemoteObject implements ServerMessage {
    List<ClientBroadcaster> broadcasters = new LinkedList<>();

    protected ServerMessageImpl() throws RemoteException {
        super();
    }

    @Override
    public void send(String name, String message) throws RemoteException {
        System.out.println(name + ": " + message);
        sendBroadcast(name, message);
    }

    @Override
    public void connect(String name, ClientBroadcaster clientBroadcaster) {
        try {
            clientBroadcaster.setName(name);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.format("%s already connected\n", name);
        broadcasters.add(clientBroadcaster);
    }

    private void sendBroadcast(String name, String message) throws RemoteException {
       System.out.println(broadcasters.size());
        for (ClientBroadcaster item : broadcasters){
            item.getMessagesFromOtherClients(name, message);
        }
    }
}
