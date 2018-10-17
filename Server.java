import java.io.*;
import java.net.*;
public class Server {
	public static void main(String[] args) {
		try {
			//Server needs to create serverSocket and socket.
			ServerSocket sSock = new ServerSocket(1201);
			Socket sock = sSock.accept();

			DataInputStream din = new DataInputStream(sock.getInputStream());
			DataOutputStream dout = new DataOutputStream(sock.getOutputStream());

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			String msgin = "";
			String msgout ="";
			//Block of code that is responsible for reading and writing messages
			//This while loop will run forever or until this socket is closed
			while(!msgin.equals("end")) {
				msgin = din.readUTF();
				System.out.println(msgin);
				msgout = reader.readLine();
				dout.writeUTF("Server: " + msgout);
				dout.flush();
			}
			//End message block
		} catch (Exception e) {
			//When client closes its socket, server's gets closed too so an expection gets thrown
			/*This is where we output the session end message because we can give a message to the
			user some information of why it's throwing an expection. We chose to give the user
			a simple message telling them the session has ended. */
			System.out.println("The Session has ended");
		}
		
	}
}
