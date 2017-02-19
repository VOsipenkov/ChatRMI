import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by 21cmPC on 19.02.2017.
 */
public class Server {
    public static void main(String[] args) throws RemoteException {
        ServerMessage serverMesage = new ServerMessageImpl();
        Registry registry = LocateRegistry.createRegistry(8888);

        registry.rebind("serverMessage", serverMesage);
        System.err.println("Server started");
    }
}
