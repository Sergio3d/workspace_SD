package SD.inputOutput.sockets.Chat;

import java.io.BufferedReader;  
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.Socket;

public class clienteEchoTCP{
    	
	public static void main(String[] args) throws IOException {
	
	//Para leer l�neas desde el teclado 
		BufferedReader userInputStream = null;  
		String userInputLine = null;
	
	//Socket para conectarse al servidor de eco 
		Socket socket = null;
	
	//Para escribir l�neas de caracteres inmediatamente en la secuencia de entrada de bytes de socket 
		PrintWriter serverOutputStream = null;
	
	//Para facilita rlas l�neas g del flujo de entrada de bytes de socket 
		BufferedReader serverInputStream = null;
	
		try {
		//1.  Crear un socket para conectarse con el servidor que se ejecuta en localhost:9999
		//n�mero ar�bigo.  
			socket = new Socket("localhost",9999);
			
		//2.	init serverOutputStream para vaciar las  fuentes de l�nea INMEDIATELY
		//al sistema operativo despu�s de que  se llame a  WriteLN
			serverOutputStream = new PrintWriter(socket.getOutputStream(),true);
			
		//3.  init serverInputStream para  lineas de lectura del servidor
			InputStream is = socket.getInputStream();
			InputStreamReader ir = new InputStreamReader(is);
			serverInputStream = new BufferedReader(ir);	
		//4.  init userInputStream para leer lineas desde el teclado
			InputStreamReader ik = new InputStreamReader(System.in);
			userInputStream = new BufferedReader(ik);
		//5.  Leer lineas desde el teclado hasta ctrl-Z de crtl-D para eof
			boolean eof = false;
			do {//eof windows = ^z . eof linux = ^D
				userInputLine = userInputStream.readLine();
				eof = (userInputLine == null);
				if (!eof) { 				
		//6.  Escribir la linea  en el servidorOutputStream
    			    serverOutputStream.println(userInputLine);
				    System.out.println(serverInputStream.readLine());
				}
				    
			} while (!eof);
			socket.close();
		
		} catch (IOException e) { 
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
}

