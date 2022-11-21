package SD.inputOutput.sockets.echo.multihilo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
public class KeyboardThread implements Runnable {
    Socket socket = null;
    
    public KeyboardThread(Socket socket) {
        // 1. Initialize the thread
        this.socket=socket;
    }
    
    public void run () {
        String inputLine = null;
        try {
            //2. Create an input line stream for Reading lines from the socket byte input stream
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader userInputLine = new BufferedReader(ir);
            //3. Create an output line stream for Writing lines to the socket byte output stream INMEDIATELY
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os,true);
            //4. while not *
            do{
                //5. Read a line for the input line stream
                inputLine = userInputLine.readLine();
                //6. Write the line in the lineOutputStream
                pw.println(inputLine);
            }while (!inputLine.contains("*"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
    }
}