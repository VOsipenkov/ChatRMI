import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by 21cmPC on 19.02.2017.
 */
public interface ClientBroadcaster extends Remote {
    public void getMessagesFromOtherClients(String message) throws RemoteException;
}
