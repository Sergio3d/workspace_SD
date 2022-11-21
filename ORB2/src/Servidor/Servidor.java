package Servidor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class Servidor {
	
	private static ServerSocket ss = null;
	private static Hashtable<Integer, Agenda> lAgendas = new Hashtable<Integer, Agenda>();
	private static int newIdAgenda = 0;
	
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
				int cod = dis.readInt();
				switch(cod) {
					case 1:
						crear(tres);
						break;
					case 2:
						asociar(dis, tres);
						break;
					case 3:
						obtener(dis, tres);
						
				}
				cs.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	private static void obtener(DataInputStream dis, DataOutputStream tres) throws IOException {
		int IdAgenda = dis.readInt();
		
		System.out.println("Numero IdAgenda: "+IdAgenda);
		Agenda Agenda = lAgendas.get(IdAgenda);
		if(Agenda!=null){
			int num = Agenda.obtener(dis.readUTF());
			System.out.println("Numero obtener: "+num);
			if(num!=0) {
				tres.writeBoolean(true);
				tres.writeInt(num);
			}else {
				tres.writeBoolean(false);
			}
		}else {
			tres.writeBoolean(false);
		}
	}

	private static void asociar(DataInputStream dis, DataOutputStream tres) throws IOException {
		int idAgenda = dis.readInt();
		String nombre = dis.readUTF();
		int numero = dis.readInt();
		Agenda agenda = lAgendas.get(idAgenda);
		if(agenda != null){
			agenda.asociar(nombre, numero);
			System.out.println("Numero asociar: "+agenda.obtener(nombre));
			tres.writeBoolean(true);
		}else{
			tres.writeBoolean(false);
		}
	}

	private static void crear(DataOutputStream tres) throws IOException {
		Agenda hagenda = new Agenda();
		lAgendas.put(newIdAgenda, hagenda);
		System.out.println("Numero newIdAgenda: "+newIdAgenda);
		if(lAgendas.contains(hagenda)){
			tres.writeBoolean(true);
			tres.writeInt(newIdAgenda++);
		}else{
			tres.writeBoolean(false);
		}
	}
	
}
