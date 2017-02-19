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
    public static JTextField field;
    public static ServerMessage serverMesage;

    public static void showUI() {
        JFrame frame = new JFrame("Client");
        frame.setSize(new Dimension(300, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        field = new JTextField(10);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    serverMesage.send(field.getText().trim());
                    field.setText("");
                    field.requestFocus();
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
        });
        sendButton.setMaximumSize(new Dimension(5, 5));

        JPanel panel = new JPanel();
        panel.add(field);
        panel.add(sendButton);

        frame.getContentPane().add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        showUI();

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8888);
        serverMesage = (ServerMessage) registry.lookup("serverMessage");
    }

}
