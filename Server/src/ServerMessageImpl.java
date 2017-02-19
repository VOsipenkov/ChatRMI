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
    public void send(String message) throws RemoteException {
        System.out.println(message);
    }
}
