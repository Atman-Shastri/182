package practicalone.chat.multiclient;

import baseclasses.multiclient.Client;

public class SecondChatClient {

	public static void main(String[] args) {
		String url = ChatServer.url;
		int port = ChatServer.port;
		Client client = new Client();
		client.setUserName("Yadav");
		client.chatWith("Baban");
		client.initializeConnection(url, port);
	}

}
