package SD.inputOutput.sockets.echo.multihilo;

import java.io.BufferedReader;  
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.Socket;

public class clienteChat{
    	
	public static void main(String[] args) throws IOException {
	
	//Socket para conectarse al servidor
		Socket socket = null;
	
		try {
		//1.  Crear un socket para conectarse con el servidor que se ejecuta en localhost:9999
		//n�mero ar�bigo.  
			socket = new Socket("localhost",9999);
			Thread kt = new Thread(new KeyboardThread(socket));
			Thread st = new Thread(new ScreenThread(socket));
			kt.start();
			st.start();
			kt.join();
			st.join();
			socket.close();
		} catch (IOException e) { 
			System.err.println(e.getMessage());
			System.exit(1);
		} catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}

