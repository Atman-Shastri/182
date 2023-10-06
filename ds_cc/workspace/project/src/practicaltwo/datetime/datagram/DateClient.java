package practicaltwo.datetime.datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DateClient {
	public static void main(String[] args) {
		DatagramSocket socket = null;

		try {
			socket = new DatagramSocket();

			InetAddress serverAddress = InetAddress.getByName("localhost"); // Server's address
			int serverPort = 9876; // Server's port

			// Send a request for "date"
			String requestDate = "date";
			byte[] sendDataDate = requestDate.getBytes();
			DatagramPacket sendPacketDate = new DatagramPacket(sendDataDate, sendDataDate.length, serverAddress,
					serverPort);
			socket.send(sendPacketDate);

			// Receive the date response
			byte[] receiveDataDate = new byte[1024];
			DatagramPacket receivePacketDate = new DatagramPacket(receiveDataDate, receiveDataDate.length);
			socket.receive(receivePacketDate);
			String dateResponse = new String(receivePacketDate.getData()).trim();

			System.out.println("Date from server: " + dateResponse);

			// Send a request for "time"
			String requestTime = "time";
			byte[] sendDataTime = requestTime.getBytes();
			DatagramPacket sendPacketTime = new DatagramPacket(sendDataTime, sendDataTime.length, serverAddress,
					serverPort);
			socket.send(sendPacketTime);

			// Receive the time response
			byte[] receiveDataTime = new byte[1024];
			DatagramPacket receivePacketTime = new DatagramPacket(receiveDataTime, receiveDataTime.length);
			socket.receive(receivePacketTime);
			String timeResponse = new String(receivePacketTime.getData()).trim();

			System.out.println("Time from server: " + timeResponse);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
	}
}
