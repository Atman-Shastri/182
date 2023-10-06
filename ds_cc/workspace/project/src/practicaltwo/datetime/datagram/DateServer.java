package practicaltwo.datetime.datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class DateServer {
	public static void main(String[] args) {
		DatagramSocket socket = null;

		try {
			socket = new DatagramSocket(9876); // Port number to listen on

			System.out.println("Server is running. Waiting for client requests...");

			while (true) {
				byte[] receiveData = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				socket.receive(receivePacket);

				String request = new String(receivePacket.getData()).trim();
				InetAddress clientAddress = receivePacket.getAddress();
				int clientPort = receivePacket.getPort();

				String response = "";

				if (request.equals("date")) {
					response = new Date().toString();
				} else if (request.equals("time")) {
					response = new Date().toInstant().toString();
				} else {
					response = "Invalid request. Please use 'date' or 'time'.";
				}

				byte[] sendData = response.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
				socket.send(sendPacket);

				System.out.println("Response sent to client: " + response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
	}
}
