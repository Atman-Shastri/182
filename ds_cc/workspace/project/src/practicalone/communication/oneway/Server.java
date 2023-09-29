package practicalone.communication.oneway;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		try (ServerSocket server = new ServerSocket(1234)) {
			Socket client = server.accept();
			DataInputStream inputStream = new DataInputStream(client.getInputStream());
			String message = inputStream.readUTF();
			System.out.println("Message from the client: " + message);
		}
	}

}
