package unit2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPClient {

	public static void main(String[] args) throws Exception {
		String s = "How are you?";
		DatagramSocket ds = new DatagramSocket();
		InetAddress ip = InetAddress.getByName("localhost");
		DatagramPacket p = new DatagramPacket(s.getBytes(),s.length(),ip,2222);
		ds.send(p);
	}

}