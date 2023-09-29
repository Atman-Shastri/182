package practicalone.chat.multiclient;

import baseclasses.multiclient.Server;

public class ChatServer {
	static String url = "localhost";
	static int port = 1223;

	public static void main(String[] args) throws Exception {
		Server server = new Server();
		server.startServer(port);
	}
}
