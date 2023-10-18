package practical_three;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JFrame;
import javax.swing.*;

public class MyClient2 extends JFrame implements ActionListener {

	JTextField tf1, tf2;
	JButton btn;
	JLabel lbl1, lbl2;

	MyClient2() {
		tf1 = new JTextField(10);
		tf2 = new JTextField(10);
		lbl1 = new JLabel("Enter First Number: ");
		lbl2 = new JLabel("Enter Second Number: ");
		btn = new JButton("Submit");
		
		add(lbl1);
		add(lbl2);
		add(tf1);
		add(tf2);
		add(btn);
		
		btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			MyInterface obj = (MyInterface)Naming.lookup("rmi://localhost:2099/g");
			int a = Integer.parseInt(tf1.getText());
			int b = Integer.parseInt(tf2.getText());
			lbl1.setText(obj.find(a, b) + " is greatest");
		}catch(Exception exception) {
			System.out.println(exception);
		}

	}
	
	public static void main(String[] args) {
		MyClient2 c = new MyClient2();
		c.setLayout(new GridLayout(6,1));
		c.setVisible(true);
		c.setSize(300,300);

	}

}
