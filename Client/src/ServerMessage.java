import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by 21cmPC on 19.02.2017.
 */
public interface ServerMessage extends Remote {
    public void send(String message) throws RemoteException;
}
