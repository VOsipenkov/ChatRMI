import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by 21cmPC on 19.02.2017.
 */
public class Client {
    public static ServerMessage serverMesage;

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8888);
        serverMesage = (ServerMessage) registry.lookup("serverMessage");

        new UI(serverMesage);
    }

}
