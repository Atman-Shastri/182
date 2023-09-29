package baseclasses.singleclient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements ActionListener, Runnable {
	Gui gui = new Gui("Send");
	BufferedReader bufferedReader;
	PrintWriter printWriter;
	String serverName;

	public Server(String windowTitle) {
		serverName = windowTitle;
		gui.button.addActionListener(this);
		gui.setWindowProperties(windowTitle);
		addListenerToEnterKey();
	}

	public void initializeConnection(String url, int port) {
		ServerSocket server;
		Socket client;
		Thread thread;
		try {
			server = new ServerSocket(port);
			client = server.accept();
			InputStream clientInput = client.getInputStream();
			InputStreamReader clientInputReader = new InputStreamReader(clientInput);
			bufferedReader = new BufferedReader(clientInputReader);
			OutputStream clientOutputStream = client.getOutputStream();
			printWriter = new PrintWriter(clientOutputStream, true);
		} catch (Exception exception) {
			gui.showExceptionInGui(exception);
			System.out.println(exception);
			System.exit(1);
		}
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String text = gui.textField.getText();
		printWriter.println(text);
		gui.textArea.append(serverName + ": " + text + "\n");
		gui.textField.setText("");
	}

	public void addListenerToEnterKey() {
		gui.textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String text = gui.textField.getText();
					printWriter.println(text);
					gui.textArea.append(serverName + ": " + text + "\n");
					gui.textField.setText("");
				}
			}
		});
	}

	@Override
	public void run() {
		while (true) {
			try {
				String bufferLine = bufferedReader.readLine();
				String serverMessage = "Client: " + bufferLine + "\n";
				gui.textArea.append(serverMessage);
			} catch (IOException ioException) {
				gui.showExceptionInGui(ioException);
				System.out.println(ioException);
				System.exit(1);
			} catch (Exception exception) {
				gui.showExceptionInGui(exception);
				System.out.println(exception);
				System.exit(1);
			}
		}
	}
}
