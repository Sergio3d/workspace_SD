package SD.inputOutput.sockets.echo.multihilo;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidorChat {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
        //localhost:port
        serverSocket =new ServerSocket(9999);
        System.out.println("Echo Server is waiting for connections");
            do {
                //1. Accept a new connection and increment the current connections
                socket = serverSocket.accept();
                //2. Create the thread with the socket and the number of connection
                Thread kt = new Thread(new KeyboardThread(socket));
                Thread st = new Thread(new ScreenThread(socket));
                //3. Start the thread
                kt.start();
                st.start();
                kt.join();
                st.join();
                socket.close();
            } while(socket.getKeepAlive());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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