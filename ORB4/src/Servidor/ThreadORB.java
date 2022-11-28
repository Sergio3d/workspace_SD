package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadORB implements Runnable{

	Socket sc;
	DataInputStream dis;
	DataOutputStream dos; 
	
	public ThreadORB(Socket sc) {
		this.sc=sc;
		try {
		
		this.dis = new DataInputStream(this.sc.getInputStream());
		this.dos = new DataOutputStream(this.sc.getOutputStream());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
			int iid = dis.readInt();
			// call the process method of the skeleton
			MiniORB.getInterface(iid).process(dis, dos);
			sc.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
