package practicalone.chat.singleclient;

import baseclasses.singleclient.Server;

public class ChatServer {
	static String url = "localhost";
	static int port = 8989;

	public static void main(String[] args) {
		String windowTitle = "Server";
		Server server = new Server(windowTitle);
		server.initializeConnection(url, port);

	}

}
