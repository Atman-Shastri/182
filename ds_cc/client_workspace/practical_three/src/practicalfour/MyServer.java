package practicalfour;

import java.beans.Statement;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import com.mysql.*;

public class MyServer extends UnicastRemoteObject implements MyInterface {
	String str = "";

	protected MyServer() throws RemoteException {
		super();
	}

	public static void main(String[] args) throws RemoteException {
		MyServer server = new MyServer();
	}

	@Override
	public String getData() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Library","root","root");
			java.sql.Statement statement = connection.createStatement();
			
			String query = "Select * from book";
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				str += rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + "\n";
			}
			
		} catch(Exception exception) {
			System.out.println(exception);
		}
		return str;
	}

}
