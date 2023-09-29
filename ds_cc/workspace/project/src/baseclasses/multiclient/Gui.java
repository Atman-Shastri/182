package baseclasses.multiclient;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Gui extends Frame {
	TextArea textArea;
	TextField textField;
	Button sendButton, closeButton;
	WindowAdapter windowAdapter;
	Label label;
	Font font;

	public Gui() {
		textArea = new TextArea(50, 50);
		textArea.setEditable(false);
		textField = new TextField(50);
		sendButton = new Button("SEND");
		closeButton = new Button("CLOSE");
		windowAdapter = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		addWindowListener(windowAdapter);
		label = new Label("Baban Yadav, 187");
		font = new Font("Arial", Font.PLAIN, 24);
		label.setFont(font);

	}

	public void setWindowProperties(String LoginName) {
		setSize(600, 400);
		setLayout(new GridLayout(2, 1));
		add(textArea);
		Panel panel = new Panel();
		panel.add(textField);
		panel.add(sendButton);
		panel.add(closeButton);
		panel.add(label);
		add(panel);
		setTitle(LoginName);
		setVisible(true);
	}

	public void showExceptionInGui(Exception exception) {
		JFrame jframe = new JFrame();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String errorMessage = "Failed to start chat: \n";
		if (exception instanceof IOException) {
			errorMessage = "Check server status\n";
		}
		JOptionPane.showMessageDialog(jframe, errorMessage + exception.getMessage(), "Error",
				JOptionPane.ERROR_MESSAGE);
		jframe.setSize(300, 200);
		jframe.setVisible(true);
	}
}
