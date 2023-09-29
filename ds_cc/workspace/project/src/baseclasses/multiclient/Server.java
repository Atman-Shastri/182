package baseclasses.multiclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

public class Server {
	static Vector<Socket> clients = new Vector<>();
	static Vector<String> loginNames = new Vector<>();

	public void startServer(int port) throws Exception {
		try (ServerSocket server = new ServerSocket(port)) {
			System.out.println("Started server");

			while (true) {
				Socket client = server.accept();
				new AcceptClient(client);
			}
		}
	}
}

class AcceptClient extends Thread {
	Vector<Socket> clients = Server.clients;
	Vector<String> loginNames = Server.loginNames;
	DataInputStream dataInputStream;
	DataOutputStream dataOutputStream;

	// default parameterised constructor
	public AcceptClient(Socket client) throws Exception {
		dataInputStream = new DataInputStream(client.getInputStream());
		dataOutputStream = new DataOutputStream(client.getOutputStream());
		String LoginName = dataInputStream.readUTF();
		System.out.println(LoginName + " is now online");
		loginNames.add(LoginName);
		clients.add(client);
		start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				String messageFromClient = dataInputStream.readUTF();
				StringTokenizer token = new StringTokenizer(messageFromClient, " ");
				String userName = token.nextToken();
				String MsgType = token.nextToken();
				int clientCount = 0;

				if (MsgType.equals("LOGOUT")) {
					logoutUser(clientCount, userName);
				} else {
					// Create message from tokens
					String message = "";
					while (token.hasMoreTokens()) {
						message += token.nextToken() + " ";
					}
					sendMessageToUser(clientCount, userName, message);

				}
				if (loginNames.size() == 0) {
					System.out.println("All clients are offline, closing server");
					System.exit(0);
				}
			} catch (IOException e) {

			}
		}

	}

	public void logoutUser(int clientCount, String userName) {
		for (clientCount = 0; clientCount < loginNames.size(); clientCount++) {
			if (loginNames.elementAt(clientCount).equals(userName)) {
				loginNames.removeElementAt(clientCount);
				clients.removeElementAt(clientCount);
				System.out.println(userName + " logged out");
				break;
			}
		}

	}

	public void sendMessageToUser(int clientCount, String userName, String msg) throws IOException {
		for (clientCount = 0; clientCount < loginNames.size(); clientCount++) {
			if (loginNames.elementAt(clientCount).equals(userName)) {
				Socket dSoc = clients.elementAt(clientCount);
				DataOutputStream ddos = new DataOutputStream(dSoc.getOutputStream());
				ddos.writeUTF(msg);
				break;
			}
		}

		// If sending message fails,
		// Check if user is online
		if (clientCount == loginNames.size()) {
			dataOutputStream.writeUTF("Server: " + userName + " is offline");
		}

	}
}
