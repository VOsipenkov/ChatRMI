import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by 21cmPC on 19.02.2017.
 */
public class ClientBroadcasterImpl extends UnicastRemoteObject implements ClientBroadcaster {
    private UI ui;
//    private static int portCounter = 8889;

    protected ClientBroadcasterImpl(UI ui) throws RemoteException {
        super();
        this.ui = ui;
    }

    @Override
    public void getMessagesFromOtherClients(String name, String message) throws RemoteException {
        ui.printOnChatArea(message.trim());
    }
}
