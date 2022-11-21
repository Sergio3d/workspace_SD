package Servidor;
//prueba
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	private static ServerSocket ss = null;
	private static Agenda hagenda = null;
	
	public static void main(String[] args) {
		
		try {
			ss = new ServerSocket(9999);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			try {
				
				Socket cs = ss.accept();
				DataInputStream dis = new DataInputStream(cs.getInputStream());
				DataOutputStream tres = new DataOutputStream(cs.getOutputStream());
				int cod = dis.read();
				switch(cod) {
					case 1:
						if(hagenda == null) {
							hagenda = new Agenda();
							tres.writeBoolean(true);
						}else {
							tres.writeBoolean(false);
						}
						break;
					case 2:
						String nombre =dis.readUTF();
						int numero = (int) dis.readInt();
						hagenda.asociar(nombre, numero);
						tres.writeBoolean(true);
						break;
					case 3:
						int num = hagenda.obtener(dis.readUTF());
						if(num!=0) {
							tres.writeBoolean(true);
							tres.writeInt(num);
						}else {
							tres.writeBoolean(false);
						}
						
				}
				cs.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
