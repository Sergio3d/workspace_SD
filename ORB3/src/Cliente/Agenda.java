package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Agenda implements IRepositorio{

	private int idAgenda;
	public Agenda() {
		try {
			Socket cs = new Socket("localhost",9999);
			DataInputStream dis = new DataInputStream(cs.getInputStream());
			DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
			dos.writeInt(1);
			dos.writeInt(1);
			if(dis.readBoolean()) {
				System.out.println("Agenda creada correctamente");
			}else {
				System.out.println("Ya existe una Agenda");
			}
			idAgenda = dis.readInt();
			cs.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void asociar(String nombre, int i) {
		// TODO Auto-generated method stub
		try {
			Socket cs = new Socket("localhost",9999);
			DataInputStream dis = new DataInputStream(cs.getInputStream());
			DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
			dos.writeInt(1);
			dos.writeInt(2);
			dos.writeInt(idAgenda);
			dos.writeUTF(nombre);
			dos.writeInt(i);
			if(dis.readBoolean()) {
				System.out.println("Contacto a?adido");
			}
			cs.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int obtener(String nombre) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Socket cs = new Socket("localhost",9999);
			DataInputStream dis = new DataInputStream(cs.getInputStream());
			DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
			dos.writeInt(1);
			dos.writeInt(3);
			dos.writeInt(idAgenda);
			dos.writeUTF(nombre);
			if(dis.readBoolean()) {
				result = (int) dis.readInt();
			}else {
				result = 0;
			}
			cs.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
