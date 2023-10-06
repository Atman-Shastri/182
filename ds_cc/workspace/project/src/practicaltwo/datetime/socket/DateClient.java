package practicaltwo.datetime.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class DateClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("localhost", 4444);
		DataInputStream dis = new DataInputStream(s.getInputStream());

		String date = dis.readUTF();
		String time = dis.readUTF();
		System.out.println("Date: " + date);
		System.out.println("Time: " + time);

	}

}
