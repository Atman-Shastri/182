package practical_four;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

@SuppressWarnings("serial")
public class MyServer extends UnicastRemoteObject implements MyInterface {

	String str = "";

	MyServer() throws RemoteException {
		super();
	}

	public String getData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from book");
			while (rs.next()) {
				str += rs.getString(1) + " " + rs.getString(2) + " \n ";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return str;
	}

	@Override
	public boolean insertData() throws RemoteException {
		boolean acknowledgement = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "root");
			Statement st = con.createStatement();
			int result = st.executeUpdate("insert into book values(1,'Harry Potter', 'J.K Rowling')");
			System.out.println(result + " rows affected");
			if (result != 0) {
				acknowledgement = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return acknowledgement;
	}

	@Override
	public boolean updateData() throws RemoteException {
		boolean acknowledgement = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "root");
			Statement st = con.createStatement();
			int result = st.executeUpdate("update book set book_name='Twilight' where book_id=1;");
			System.out.println(result + " rows affected");
			if (result != 0) {
				acknowledgement = true;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return acknowledgement;

	}

}
