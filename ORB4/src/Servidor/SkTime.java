package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SkTime implements ISkeleton{

	@Override
	public void process(DataInputStream dis, DataOutputStream dos) {
		
		Time objTime = new Time();
		try {
			
			int cod = dis.readInt();
			switch(cod) {
				case 1:
					dos.writeInt(objTime.getHour());
					break;
				case 2:
					dos.writeInt(objTime.getMinute());
					break;
				case 3:
					dos.writeInt(objTime.getSeconds());
					break;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public int getIid() {
		// TODO Auto-generated method stub
		return 2;
	}

}
