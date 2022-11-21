package SD.inputOutput.sockets.Chat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidorEchoMultihilo {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        int numConnections = 0;
        int max = 3;
        try {
        //localhost:port
        serverSocket =new ServerSocket(9999);
        System.out.println("Echo Server is waiting for connections");
        while (numConnections < max) {
            //1. Accept a new connection and increment the current connections
            socket = serverSocket.accept();
            numConnections++;
            //2. Create the thread with the socket and the number of connection
            Thread echoServer = new Thread(new EchoService(socket,numConnections));
            //3. Start the thread
            echoServer.start();
        }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (serverSocket != null)
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
        }
    }
}