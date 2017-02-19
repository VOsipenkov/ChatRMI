import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by 21cmPC on 19.02.2017.
 */
public class ClientBroadcasterImpl extends UnicastRemoteObject implements ClientBroadcaster {
    private UI ui;

    protected ClientBroadcasterImpl(UI ui) throws RemoteException {
        super();
        this.ui = ui;
    }

    @Override
    public void getMessagesFromOtherClients(String message) throws RemoteException {
        ui.printOnChatArea(message.trim());
    }
}
