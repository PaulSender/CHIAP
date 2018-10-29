package server;

import java.io.*;
import java.util.*;
import java.net.*;

public class Server {
	
	ArrayList<ServerConnection> connections = new ArrayList<ServerConnection>();
	ServerSocket ss;
	boolean shouldRun = true;
	
	
	public Server() {
		try {
			ss = new ServerSocket(3333);
		while(shouldRun) {
			Socket s = ss.accept();
			ServerConnection sc = new ServerConnection(s, this);
			sc.start();
			connections.add(sc);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();

	}

}
