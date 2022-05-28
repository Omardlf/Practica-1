import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ChatClientMain {

    public static void main(String[] args) {
        Scanner Leer = new Scanner(System.in);
        String message = "";
        System.out.println("Ingresa tu nombre");
        message = Leer.nextLine();
        String cleanedUserName = message.replaceAll("\\s+","_");
        cleanedUserName = message.replaceAll("\\W+","_");
        try {
            ChatClient client = new ChatClient(cleanedUserName);
            client.startClient();
            while (true){
                message = Leer.nextLine();
                client.serverIF.updateChat(cleanedUserName,message);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

