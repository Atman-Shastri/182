package practicalone.communication.twoway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		Socket client = new Socket("localhost", 1234);
		DataInputStream inputStream = new DataInputStream(client.getInputStream());
		DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
		outputStream.writeUTF("Hello Baban, message from client");
		String serverMessage = inputStream.readUTF();
		System.out.println("Message from the server: " + serverMessage);
		client.close();

	}

}
