package baseclasses.multiclient;

import java.awt.Button;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable {
	String UserName;
	String recipientName;
	Socket client;
	DataInputStream dataInputStream;
	DataOutputStream dataOutputStream;
	Thread thread = null;
	Gui gui = new Gui();

	public void initializeConnection(String url, int port) {
		try {
			client = new Socket(url, port);
			dataInputStream = new DataInputStream(client.getInputStream());
			dataOutputStream = new DataOutputStream(client.getOutputStream());
			dataOutputStream.writeUTF(UserName);
		} catch (IOException exception) {
			gui.showExceptionInGui(exception);
			System.out.println(exception);
			System.exit(1);
		}
		thread = new Thread(this);
		thread.start();
	}

	public void addActionListeners() {
		Button sendButton = gui.sendButton;
		Button closeButton = gui.closeButton;
		TextField textField = gui.textField;
		TextArea textArea = gui.textArea;

		// Action listener for the Send button
		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent action) {
				if (action.getSource() == sendButton) {
					try {
						// Send the message to another client
						String text = textField.getText().toString();
						dataOutputStream.writeUTF(recipientName + " DATA " + text);
						textArea.append("\n" + UserName + ": " + text);
						textField.setText("");
					} catch (IOException ex) {
						Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		});

		// Action listener for the Close button
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent action) {
				if (action.getSource() == closeButton) {
					try {
						// Send logout message
						dataOutputStream.writeUTF(UserName + " LOGOUT");
						System.exit(1);
					} catch (IOException ioException) {
						Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ioException);
					}
				}
			}
		});

		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						// Send the message to another client
						String text = textField.getText().toString();
						dataOutputStream.writeUTF(recipientName + " DATA " + text);
						textArea.append("\n" + UserName + ": " + text);
						textField.setText("");
					} catch (IOException ex) {
						Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		});
	}

	@Override
	public void run() {
		TextArea textArea = gui.textArea;
		while (true) {
			try {
				String response = dataInputStream.readUTF();
				if (response.contains("offline")) {
					textArea.append("\n" + response);
				} else {
					textArea.append("\n" + recipientName + ": " + response);
				}
			} catch (IOException ioException) {
				Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ioException);
			}
		}
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
		gui.setWindowProperties(UserName);
		addActionListeners();
	}

	public void chatWith(String recipientName) {
		this.recipientName = recipientName;
	}

}
