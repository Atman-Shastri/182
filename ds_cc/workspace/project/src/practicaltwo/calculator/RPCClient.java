package practicaltwo.calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class RPCClient {
	RPCClient() {

		try {
			InetAddress ia = InetAddress.getLocalHost();
			DatagramSocket ds = new DatagramSocket();
			DatagramSocket ds1 = new DatagramSocket(1300);
			System.out.println("\n RPC Client");
			System.out.println("--------\n");
			System.out.println("Enter Method Name with Parameter like add 3 4\n");

			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String str = br.readLine();
				byte[] b = str.getBytes();
				DatagramPacket dp = new DatagramPacket(b, b.length, ia, 1200);
				ds.send(dp);

				dp = new DatagramPacket(b, b.length);
				ds1.receive(dp);
				String s = new String(dp.getData(), 0, dp.getLength());
				System.out.println("\nResult= " + s + "\n");
				System.out.println("\n\nEnter Method Name with Parameter like add 3 4\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new RPCClient();
	}

}
