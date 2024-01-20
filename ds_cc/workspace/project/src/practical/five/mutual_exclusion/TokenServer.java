package practical.five.mutual_exclusion;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TokenServer {

	public static DatagramSocket ds;
	public static DatagramPacket dp;

	public static void main(String[] args) throws Exception {
		ds = new DatagramSocket(1000);
		while (true) {
			byte buff[] = new byte[1024];
			ds.receive(dp = new DatagramPacket(buff, buff.length));
			String str = new String(dp.getData(), 0, dp.getLength());
			System.out.println("Message from " + str);
		}
	}
}
