package client;

import java.net.*;
import java.io.*;

public class ClientConnection extends Thread{
	
	Socket s;
	DataInputStream din;
	DataOutputStream dout;
	
	public ClientConnection(Socket socket, Client client) {
		
		s = socket;
		
		try {
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendStringToServer(String text) {
		try {
			dout.writeUTF(text);
			dout.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		try {
			while(din.available() == 0) {
				try {
					Thread.sleep(1);
					
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			String reply = din.readUTF();
			System.out.println(reply);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void close() {
		try {
			din.close();
			dout.close();
			s.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
	}

}
