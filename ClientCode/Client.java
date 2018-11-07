package client;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	

	ClientConnection cc;
	
	
	public Client() {
		try {
		    Socket s = new Socket("localhost", 3333);
		    cc = new ClientConnection(s, this);
		    
			
			listenForInput();
		}
		catch(UnknownHostException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void listenForInput() {
		Scanner console = new Scanner(System.in);
		
		while(true) {
			while(!console.hasNextLine()) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			String input = console.nextLine();
			
			if(input.toLowerCase().equals("quit")) {
				break;
			}
			cc.sendStringToServer(input);
		}
		cc.close();
	}
	public static void main(String[] args) {
		new Client();

	}

}
