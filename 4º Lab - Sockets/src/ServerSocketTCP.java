import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTCP {
	
	public static void main (String[] args){
		ServerSocket server;
		try {
			server = new ServerSocket(10000);
			while ( true) {
				Socket socket = server.accept(); //accept new connection
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				//read from string from input stream socket
				InputStreamReader ir = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(ir);
				String saludo = br.readLine();
				//write to output stream socket the string read
				PrintWriter pw = new PrintWriter(os,true);
				pw.println(saludo);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
