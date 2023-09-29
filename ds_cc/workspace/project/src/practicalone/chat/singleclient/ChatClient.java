package practicalone.chat.singleclient;

import baseclasses.singleclient.Client;

public class ChatClient {

	public static void main(String[] args) {
		String url = ChatServer.url;
		int port = ChatServer.port;
		String windowTitle = "Client";
		Client client = new Client(windowTitle);
		client.initializeConnection(url, port);

	}

}
