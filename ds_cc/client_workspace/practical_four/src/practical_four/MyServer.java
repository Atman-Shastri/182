package practical_four;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class MyServer extends UnicastRemoteObject implements MyInterface {

	String str = " ";

	MyServer() throws RemoteException {
		super();
	}

	public String getData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ library", "root", "");
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

}
