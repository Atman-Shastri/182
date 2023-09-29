package practicalone.communication.twoway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		try (ServerSocket server = new ServerSocket(1234)) {
			Socket client = server.accept();
			DataInputStream inputStream = new DataInputStream(client.getInputStream());
			DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
			outputStream.writeUTF("Hello Baban, message from server");
			String message = inputStream.readUTF();
			System.out.println("Message from the client: " + message);
		}
	}

}
