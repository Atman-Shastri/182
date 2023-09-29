package practicalone.communication.oneway;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		Socket client = new Socket("localhost", 1234);
		DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
		outputStream.writeUTF("Hello, I am Baban Yadav, 187");
		client.close();
	}

}
