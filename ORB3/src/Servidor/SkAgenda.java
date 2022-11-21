package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Hashtable;

public class SkAgenda implements ISkeleton {

	private Hashtable<Integer, Agenda> skAgenda = new Hashtable<Integer, Agenda>();

	Agenda hagenda;
	@Override
	public void process(DataInputStream dis, DataOutputStream dos) {
		// TODO Auto-generated method stub
		try {
			
			switch(dis.readInt()) {
			case 1:
				hagenda = new Agenda();
				if(!skAgenda.contains(hagenda)){
					int key = skAgenda.size()+1;
					skAgenda.put(key, hagenda);
					dos.writeBoolean(true);
					dos.writeInt(key);
				}else{
					dos.writeBoolean(false);
				}
				break;
			case 2:
				hagenda = skAgenda.get(dis.readInt());
				if(hagenda != null){
					hagenda.asociar(dis.readUTF(),dis.readInt());
					dos.writeBoolean(true);
				}else{
					dos.writeBoolean(false);
				}
				break;
			case 3:
				hagenda = skAgenda.get(dis.readInt());
				if(hagenda!=null){
					int num = hagenda.obtener(dis.readUTF());
					if(num!=0) {
						dos.writeBoolean(true);
						dos.writeInt(num);
					}else {
						dos.writeBoolean(false);
					}
				}else {
					dos.writeBoolean(false);
				}
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
		return 1;
	}

}
