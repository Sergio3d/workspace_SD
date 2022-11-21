package SD.inputOutput.sockets.Chat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
public class EchoService implements Runnable {
    Socket socket = null;
    int id = 0; //identifier of the connection of the thread
    
    public EchoService(Socket socket, int id) {
        // 1. Initialize the thread
        this.socket=socket;
        this.id=id;
    }
    
    public void run () {
        String inputLine = null;
        try {
            //2. Create an input line stream for Reading lines from the socket byte input stream
            InputStream is = socket.getInputStream();
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader userInputLine = new BufferedReader(ir);
            //3. Create an output line stream for Writing lines to the socket byte output stream INMEDIATELY
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os,true);
            //4. while not eof
            while ((inputLine = userInputLine.readLine()) != null) {
                //5. Read a line for the input line stream
                //6. Write the line in the lineOutputStream
                pw.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
    }
}