import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) {
		try {
			Socket sock = new Socket("127.0.0.1", 1201);
			//Once the connection is established the client tells it self that the server is connected
			System.out.println("Server: This is Server");
			DataInputStream din = new DataInputStream(sock.getInputStream());
			DataOutputStream dout = new DataOutputStream(sock.getOutputStream());

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			String msgin ="";
			String msgout ="";
			//Block of code responsible for reading and writing messages
			while(!msgin.equals("end")) {
				msgout = reader.readLine();
				//Puts condition in a string so its not cap sensative
				String con = "END";
				//Once msgout is defined we can check is it meets the condition
				if (msgout.equals(con.toLowerCase())) {
					//Closes both client and server. The server throws an expection
					sock.close();
					//Ends the session
				}
				dout.writeUTF("Client: " + msgout);
				msgin = din.readUTF();
				System.out.println(msgin);
			}

			//End message block
		} catch (Exception e) {
		}
	}
}
