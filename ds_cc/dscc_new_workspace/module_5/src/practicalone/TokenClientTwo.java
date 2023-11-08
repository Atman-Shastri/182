package practicalone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TokenClientTwo {
	public static DatagramSocket ds;
	public static DatagramPacket dp;
	public static BufferedReader br;

	public static void main(String[] args) throws Exception {
		boolean hasToken = true;
		ds = new DatagramSocket(200);
		while (true) {
			if (hasToken == true) {
				System.out.println("Do you want to write data...(yes/no)");
				br = new BufferedReader(new InputStreamReader(System.in));
				String ans = br.readLine();
				if (ans.equalsIgnoreCase("yes")) {
					System.out.println("ready to write");
					System.out.println("enter the data");
					br = new BufferedReader(new InputStreamReader(System.in));
					String str = "Client-2===>" + br.readLine();
					byte buff[] = new byte[1024];
					buff = str.getBytes();
					ds.send(new DatagramPacket(buff, buff.length, InetAddress.getLocalHost(), 1000));
					System.out.println("now sending");
				} else if (ans.equalsIgnoreCase("no")) {
					System.out.println("I am Busy state");
					String msg = "token";
					byte bf1[] = new byte[1024];
					bf1 = msg.getBytes();
					ds.send(new DatagramPacket(bf1, bf1.length, InetAddress.getLocalHost(), 100));
					hasToken = false;
				}
			} else {
				try {
					System.out.println("Entering in receiving mode");
					byte bf[] = new byte[1024];
					ds.receive(dp = new DatagramPacket(bf, bf.length));
					String clientmsg = new String(dp.getData(), 0, dp.getLength());
					System.out.println("The data is " + clientmsg);
					if (clientmsg.equals("token")) {
						hasToken = true;
						System.out.println("I am leaving busy state");
					}
				} catch (Exception e) {
				}
			}
		}

	}

}
