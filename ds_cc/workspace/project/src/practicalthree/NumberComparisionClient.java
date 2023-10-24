package practicalthree;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class NumberComparisionClient extends JFrame implements ActionListener {

	JTextField numFieldOne, numFieldTwo;
	JButton submitButton;
	JLabel numLabelOne, numLabelTwo, resultLabel, atmanLabel;

	NumberComparisionClient() {
		atmanLabel = new JLabel("Atman Shastri, 182");
		numLabelOne = new JLabel("Enter First Number: ");
		numFieldOne = new JTextField(5);
		numLabelTwo = new JLabel("Enter Second Number: ");
		numFieldTwo = new JTextField(10);
		submitButton = new JButton("Submit");
		submitButton.setSize(5, 5);
		resultLabel = new JLabel("");
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

		Font customFont = new Font("Arial", Font.BOLD, 20);
		atmanLabel.setFont(customFont);
		numLabelOne.setFont(customFont);
		numFieldOne.setFont(customFont);
		numLabelTwo.setFont(customFont);
		numFieldTwo.setFont(customFont);
		submitButton.setFont(customFont);
		resultLabel.setFont(customFont);

		JPanel headerPanel = new JPanel();
		headerPanel.add(atmanLabel);

		JPanel resultPanel = new JPanel();
		resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		resultPanel.add(resultLabel);

		JPanel inputPanel = new JPanel(new GridLayout(2, 2));
		inputPanel.add(numLabelOne);
		inputPanel.add(numFieldOne);
		inputPanel.add(numLabelTwo);
		inputPanel.add(numFieldTwo);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(submitButton);
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(headerPanel);
		mainPanel.add(inputPanel);
		mainPanel.add(buttonPanel);
		mainPanel.add(resultPanel);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		add(mainPanel);
		submitButton.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			RemoteInterface obj = (RemoteInterface) Naming.lookup("rmi://localhost:2099/compare");
			int a = Integer.parseInt(numFieldOne.getText());
			int b = Integer.parseInt(numFieldTwo.getText());
			resultLabel.setText(obj.find(a, b) + " is greatest");
		} catch (Exception exception) {
			System.out.println(exception);
		}

	}

	public static void main(String[] args) {
		NumberComparisionClient c = new NumberComparisionClient();
		c.setVisible(true);
		c.setSize(500, 400);
	}

}
