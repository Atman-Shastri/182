package unit2.program3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateServer {

	DateServer() throws IOException {

		ServerSocket ss = new ServerSocket(4444);
		Socket s = ss.accept();
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		dos.writeUTF(date());
		dos.writeUTF(time());
		dos.flush();
	}

	public String date() {

		return new SimpleDateFormat("dd/mm/yyyy").format(new Date()).toString();
	}

	public String time() {
		return new SimpleDateFormat("hh:mm:ss").format(new Date()).toString();
	}

	public static void main(String[] args) throws IOException {
		DateServer d = new DateServer();

	}

}
