package practicaltwo.communication.oneway;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

	public static void main(String[] args)throws Exception {
		String s = "How are you?";
		DatagramSocket ds = new DatagramSocket(2222);
		byte[] b = new byte[1024];
		DatagramPacket p = new DatagramPacket(b,1024);
		ds.receive(p);
		String msg = new String(p.getData(),0,p.getLength());
		System.out.println("Message from client: " + msg);

	}

}
