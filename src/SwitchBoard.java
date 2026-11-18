import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SwitchBoard {
    static ArrayList<Service> serviceList =new ArrayList<Service>();
    public SwitchBoard(){
    }
    public static void main(String[] arg) {
        final int port = 6666;
        ServerSocket listener;
        Socket socket;
        try {
            listener = new ServerSocket(port);
            while (true) {
                socket = listener.accept();
                serviceList.add(new Service("test"));
                System.out.println("New connection on the port");
            }
        } catch (IOException exc) {
            System.out.println("Connexion problem");
        }
    }
}