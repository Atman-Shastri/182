package practicalone.chat.multiclient;

import baseclasses.multiclient.Client;

public class FirstChatClient {

	public static void main(String[] args) {
		String url = ChatServer.url;
		int port = ChatServer.port;
		Client client = new Client();
		client.setUserName("Baban");
		client.chatWith("Yadav");
		client.initializeConnection(url, port);
	}
}
