package Servidor;
/********************************************************************/
/* FILE: MiniORB.java
/*
/* DESCRIPTION: The class MiniORB contains the Object Request Broker
/* addInterface(): Register an Interface with its ISkeleton.
/* getInterface(): Return the ISkeleton of an interface.
/********************************************************************/
import java.util.*;
import java.net.*;
import java.io.*;
public class MiniORB {
	
	// Table for storing tuples <iid, Skeleton> where iid = interface identifier and
	// skeleton is the demultiplexer of the class
	
	private static Hashtable<Integer, ISkeleton> skTable = new Hashtable<Integer, ISkeleton>();
	private String host;
	private int port;
	ServerSocket ss = null;
	
	// --------------------------------------------------------
	// Constructor
	// --------------------------------------------------------
	
	public MiniORB(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public synchronized void addInterface(ISkeleton sk) {
		//add to the skTable the tuple (iid and sk)
		skTable.put(sk.getIid(), sk);
	}
	
	public synchronized static ISkeleton getInterface(int iid) {
		//return the skeleton of iid
		return skTable.get(iid);
	}
	
	// Create the server that accepts connections
	
	public void serve() {
		ss = null;
		try {
			ss = new ServerSocket(port);
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (true) {
			
			try {
				// Wait for an incoming connection.
				Thread thread = new Thread(new ThreadORB(ss.accept()));
				thread.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		String host = "localhost";
		int port = 9999;
		MiniORB orb = null;
		// Create and start the ORB
		orb = new MiniORB(host, port);
		// register the Agenda interface in the ORB iid Agenda = 1
		orb.addInterface(new SkAgenda());
		orb.addInterface(new SkTime());
		orb.serve();
	}
}