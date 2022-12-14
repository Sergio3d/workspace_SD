package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Time implements ITime {
	
	private  final  int iid=2;
	
	public int getHour() {

		int result=-1;
		try {
			Socket cs = new Socket("localhost",9999);
			DataInputStream dis = new DataInputStream(cs.getInputStream());
			DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
			dos.writeInt(iid);
			dos.writeInt(1);
			result = dis.readInt();
			cs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return result;
		
	}
	
	public int getMinute() {
		int result=-1;
		try {
			Socket cs = new Socket("localhost",9999);
			DataInputStream dis = new DataInputStream(cs.getInputStream());
			DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
			dos.writeInt(2);
			dos.writeInt(2);
			result = dis.readInt();
			cs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return result;
	}
	
	public int getSeconds() {
		int result=-1;
		try {
			Socket cs = new Socket("localhost",9999);
			DataInputStream dis = new DataInputStream(cs.getInputStream());
			DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
			dos.writeInt(2);
			dos.writeInt(3);
			result = dis.readInt();
			cs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return result;
	}

}