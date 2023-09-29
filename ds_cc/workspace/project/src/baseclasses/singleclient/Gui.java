package baseclasses.singleclient;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Gui extends JFrame {
	public JButton button;
	public JTextArea textArea;
	public JTextField textField;
	WindowAdapter windowAdapter;
	JLabel label;
	Font font;

	public Gui(String buttonText) {
		button = new JButton(buttonText);
		textField = new JTextField(20);
		textArea = new JTextArea(19, 30);
		textArea.setEditable(false);
		label = new JLabel("Baban Yadav, 187");
		font = new Font("Arial", Font.PLAIN, 24);
		label.setFont(font);
		windowAdapter = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};

		add(label);
		add(textArea);
		add(textField);
		add(button);
		addWindowListener(windowAdapter);
	}

	public void setWindowProperties(String title) {
		this.setLayout(new FlowLayout());
		this.setSize(400, 420);
		this.setTitle(title);
		this.setVisible(true);
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
