import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by 21cmPC on 19.02.2017.
 */
public class ServerMessageImpl extends UnicastRemoteObject implements ServerMessage {


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
        System.out.format("%s already connected\n", name);

    }

    private void sendBroadcast(String name, String message) {
//TODO sending messages for all clients
    }
}
