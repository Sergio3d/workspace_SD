
import java.io.BufferedReader;  
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;  
import java.net.ServerSocket;  
import java.net.Socket;

public class servidorEchoMonohiloTCP {

	public static void main(String[] args) throws IOException {
		
			
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
		    //1.  Crear un socket de servidor que escuche en el puerto 9999
			serverSocket = new ServerSocket(9999);
		
			//2.  Espere  una nueva conexi�n de  usuario entrante
			socket = serverSocket.accept();
		
			//3.  Lectura de  l�neas del flujo de entrada de bytes del socket
			InputStream is = socket.getInputStream();
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(ir);
		
			//4.  Escribir l�neas en el flujo de salida de bytes  de socket
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os,true);
			
			//5. Leer una l�nea del socket de flujo de entrada y hacer eco de ella en el socket de flujo de salida 
			String inputLine="";
			while(inputLine != null) {
    			inputLine = br.readLine();
    			//6.  Escriba la l�nea en el  socket de flujo de salida
			    pw.println(inputLine);
			}
		
		} catch (IOException e) { 
			System. out.println(e.getMessage());  
			serverSocket.close();
		}
	}
}
